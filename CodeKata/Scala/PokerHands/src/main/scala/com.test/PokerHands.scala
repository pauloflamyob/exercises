package com.test

object PokerHands {
  private def ACE = 14
  private case class HandValue(digitValueOfHand: Int, valueOfHand: String, hand: List[Int])

  private def convertCardsToDigits(card: String) = card match {
    case x if card.head == 'A' => ACE
    case x if card.head == 'K' => 13
    case x if card.head == 'Q' => 12
    case x if card.head == 'J' => 11
    case x if card contains "10" => 10
    case default => card.head.asDigit
  }

  private def getSortedHandValues(hand: List[String]): List[Int] = hand.map((card) => convertCardsToDigits(card)).sorted.reverse
  private def getNumberOfOccurrences(hand: List[String]): Map[Int, Int] = getSortedHandValues(hand).groupBy{ x => x }.map { case(num, occurrences) => (num, occurrences.size) }

  private def isFlush(hand: List[String]): Boolean = hand.map((card) => card.last).distinct.size == 1
  private def isStraight(hand: List[String]): Boolean = {
    val handValue = getSortedHandValues(hand)
    handValue.distinct.size == 5 && (handValue.head - 4 == handValue.last || (handValue.head == ACE && handValue(1) == 5 && handValue.last == 2))
  }
  private def isFourOfAKind(hand: List[String]): Boolean = getSortedHandValues(hand).groupBy{ x => x }.map { case(num, occurrences) => (num, occurrences.size) }.valuesIterator.max == 4
  private def isFullHouse(hand: List[String]): Boolean = getNumberOfOccurrences(hand).valuesIterator.max == 3 && getNumberOfOccurrences(hand).valuesIterator.min == 2
  private def isThreeOfAKind(hand: List[String]): Boolean = getNumberOfOccurrences(hand).size == 3 && getNumberOfOccurrences(hand).valuesIterator.max == 3
  private def isTwoPair(hand: List[String]): Boolean = getNumberOfOccurrences(hand).size == 3 && getNumberOfOccurrences(hand).valuesIterator.max == 2 && getNumberOfOccurrences(hand).valuesIterator.min == 1
  private def isAPair(hand: List[String]): Boolean = getNumberOfOccurrences(hand).size == 4 && getNumberOfOccurrences(hand).valuesIterator.max == 2

  private def getHandValue(hand: List[String]): HandValue = hand match {
    case x if isFlush(hand) && isStraight(hand) => HandValue(8, "Straight Flush", getSortedHandValues(hand))
    case x if isFourOfAKind(hand) => HandValue(7, "Four of a Kind", getSortedHandValues(hand))
    case x if isFullHouse(hand) => HandValue(6, "Full House", getSortedHandValues(hand))
    case x if isFlush(hand) => HandValue(5, "Flush", getSortedHandValues(hand))
    case x if isStraight(hand) => HandValue(4, "Straight", getSortedHandValues(hand))
    case x if isThreeOfAKind(hand) => HandValue(3, "Three of a Kind", getSortedHandValues(hand))
    case x if isTwoPair(hand) => HandValue(2, "Two Pair", getSortedHandValues(hand))
    case x if isAPair(hand) => HandValue(1, "Pair", getSortedHandValues(hand))
    case default => HandValue(0, "High Card", getSortedHandValues(hand))
  }

  private def isATie(hand1: List[String], hand2: List[String]) = (getSortedHandValues(hand1) == getSortedHandValues(hand2)) && ((isFlush(hand1) && isFlush(hand2)) || (!isFlush(hand1) && !isFlush(hand2)))

  private def createWinningMessage(handValue: String, winningColour: String): String = {
    s"${winningColour} wins with a ${handValue}"
  }

  def score(hands: List[List[String]]): String = {
    val black = hands.head
    val white = hands.last
    val blackHandValue = getHandValue(black)
    val whiteHandValue = getHandValue(white)
    if (isATie(black, white)) return "Tie"

    if(blackHandValue.digitValueOfHand > whiteHandValue.digitValueOfHand || (blackHandValue.digitValueOfHand == whiteHandValue.digitValueOfHand && blackHandValue.hand.head > whiteHandValue.hand.head)) return createWinningMessage(blackHandValue.valueOfHand, "Black")
    createWinningMessage(whiteHandValue.valueOfHand, "White")
  }
}
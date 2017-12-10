package com.test

import org.scalatest.FunSpec

class PokerHandsTest extends FunSpec {

  describe("Highest Card") {
    def generateTest(testCase: TestCase): Unit = {
      it("Result for: " + testCase.getInput) {
        assert(PokerHands.score(testCase.getInput) == testCase.getExpectedOutput)
      }
    }

    var testCases = List(
      new TestCase(List(List("2S"), List("2C")), "Tie"), new TestCase(List(List("9H"), List("9D")), "Tie"),
      new TestCase(List(List("10H"), List("10D")), "Tie"), new TestCase(List(List("JH"), List("JD")), "Tie"),
      new TestCase(List(List("QH"), List("QD")), "Tie"), new TestCase(List(List("KH"), List("KD")), "Tie"),
      new TestCase(List(List("AH"), List("AD")), "Tie"),
      new TestCase(List(List("AH", "2C", "3D", "4H", "7H"), List("AC", "2H", "3C", "4D", "7C")), "Tie"),
      new TestCase(List(List("AH", "2C", "3D", "KH", "JH"), List("AC", "2H", "3C", "KD", "JC")), "Tie"),
      new TestCase(List(List("AH", "2H", "3H", "KH", "JH"), List("AC", "2C", "3C", "KC", "JC")), "Tie"),
      new TestCase(List(List("KH", "AH", "QH", "10H", "JH"), List("2S", "2C", "3C", "KC", "JC")), "Black wins with a Straight Flush"),
      new TestCase(List(List("AH", "AD", "AC", "2S", "2D"), List("4S", "4C", "3C", "KC", "JC")), "Black wins with a Full House"),
      new TestCase(List(List("AH", "2H", "3H", "KH", "JD"), List("AC", "2C", "3C", "KC", "JC")), "White wins with a Flush"),
      new TestCase(List(List("6H", "2D", "3C", "4S", "5D"), List("2S", "2C", "3H", "KC", "JC")), "Black wins with a Straight"),
      new TestCase(List(List("AH", "2D", "3C", "4S", "JD"), List("7S", "7C", "7D", "KC", "JC")), "White wins with a Three of a Kind"),
      new TestCase(List(List("AH", "AD", "4C", "4S", "JD"), List("2S", "2C", "3C", "KC", "JC")), "Black wins with a Two Pair"),
      new TestCase(List(List("AH", "4D", "5C", "6S", "7D"), List("2S", "2C", "3C", "KC", "JC")), "White wins with a Pair"),
      new TestCase(List(List("AH", "3D"), List("KC", "3H")), "Black wins with a High Card"),
    )

    testCases.foreach(generateTest)
  }
}

class TestCase(input: List[List[String]], expectedOutput: String) {
  def getInput: List[List[String]] = input

  def getExpectedOutput: String = expectedOutput
}
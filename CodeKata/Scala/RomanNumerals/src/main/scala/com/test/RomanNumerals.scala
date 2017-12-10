package com.test

object RomanNumerals {

  private case class Roman(digitRequired: Int, one: String, five: String, ten: String)

  private def romanNumerals: List[Roman] = List(Roman(1000, "M", "", ""), Roman(100, "C", "D", "M"), Roman(10, "X", "L", "C"), Roman(1, "I", "V", "X"))

  private def convertToDigit(number: Int, modulus: Int): Int = (number % (modulus * 10)) / modulus

  private def repeatDigit(number: Int, value: String): String = List.fill(number)(value).mkString

  private def convertDigit(value: Int, one: String, five: String, ten: String): String = value match {
    case x if value >= 5 && value % 9 == 0 => convertDigit(value - 5, one, ten, "")
    case x if value >= 5 => five + convertDigit(value - 5, one, ten, "")
    case x if 0 to 3 contains value => repeatDigit(x, one)
    case 4 => one + five
  }

  def convert(number: Int): String = romanNumerals.foldLeft("")(
    (total, roman) => total.concat(
      convertDigit(
        convertToDigit(number, roman.digitRequired), roman.one, roman.five, roman.ten
      )
    )
  )
}
package game

import org.scalatest.FunSpec

class MinesweeperTest extends FunSpec {

  describe("Generate Flags") {
    def generateTest(testCase: TestCase): Unit = {
      it("should convert " + testCase.getTestcase) {
        assert(Minesweeper.generateFlags(testCase.getInput) == testCase.getExpectedOutput)
      }
    }

    var testCases = List(
      new TestCase("0 mines and 0x0 fields", List(
        List()
      ), List(
        List()
      )),
      new TestCase("0 mines and 1x1 fields", List(
        List(".")
      ), List(
        List("0")
      )),
      new TestCase("0 mines and 2x1 fields", List(
        List(".", ".")
      ), List(
        List("0", "0")
      )),
      new TestCase("0 mines and 1x2 fields", List(
        List("."),
        List(".")
      ), List(
        List("0"),
        List("0")
      )),
      new TestCase("1 mines and 1x1 fields", List(
        List("*")
      ), List(
        List("*")
      )),
      new TestCase("1 mines and 1x2 fields on the left", List(
        List("*"),
        List(".")
      ), List(
        List("*"),
        List("1")
      )),
      new TestCase("1 mines and 1x2 fields on the right", List(
        List("."),
        List("*")
      ), List(
        List("1"),
        List("*")
      )),
      new TestCase("2 mines and 1x2 fields", List(
        List("*"),
        List("*")
      ), List(
        List("*"),
        List("*")
      )),
      new TestCase("2 mines and 2x1 fields on the left", List(
        List("*", ".")
      ), List(
        List("*", "1")
      )),
      new TestCase("2 mines and 2x1 fields on the right", List(
        List(".", "*")
      ), List(
        List("1", "*")
      )),
      new TestCase("2 mines and 2x2 fields", List(
        List(".", "*"),
        List(".", "*")
      ), List(
        List("2", "*"),
        List("2", "*")
      )),
      new TestCase("3 mines and 3x3 fields placed diagonally", List(
        List("*", ".", "."),
        List(".", "*", "."),
        List(".", ".", "*")
      ), List(
        List("*", "2", "1"),
        List("2", "*", "2"),
        List("1", "2", "*")
      )),
      new TestCase("3 mines and 3x5 fields", List(
        List("*", "*", ".", ".", "."),
        List(".", ".", ".", ".", "."),
        List(".", "*", ".", ".", ".")
      ), List(
        List("*", "*", "1", "0", "0"),
        List("3", "3", "2", "0", "0"),
        List("1", "*", "1", "0", "0")
      )),
      new TestCase("2 mines and 4x4 fields", List(
        List("*", ".", ".", "."),
        List(".", ".", ".", "."),
        List(".", "*", ".", "."),
        List(".", ".", ".", ".")
      ), List(
        List("*", "1", "0", "0"),
        List("2", "2", "1", "0"),
        List("1", "*", "1", "0"),
        List("1", "1", "1", "0")
      )),
    )

    testCases.foreach(generateTest)
  }
}

class TestCase(testcase: String, input: List[List[String]], expectedOutput: List[List[String]]) {
  def getTestcase: String = testcase
  def getInput: List[List[String]] = input

  def getExpectedOutput: List[List[String]] = expectedOutput
}
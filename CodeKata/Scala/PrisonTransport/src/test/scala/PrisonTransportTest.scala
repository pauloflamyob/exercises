import org.scalatest.FunSpec

class PrisonTransportTest extends FunSpec {
  describe("Covert prisoners to cost") {
    def generateTest(testCase: TestCase): Unit = {
      it("should convert " + testCase.getInput) {
        assert(PrisonTransport.query(testCase.getInput.numberOfPrisoners, testCase.getInput.numberOfHandcuffs, testCase.getInput.handCuffedTogetherPairList) == testCase.getExpectedOutput)
      }
    }
    val input = Input(4, 2, List(
      List(1, 2),
      List(2, 4)
    ))
    val input2 = Input(4, 2, List(
      List(1, 2),
      List(1, 4)
    ))
    val input3 = Input(4, 2, List(
      List(1, 2),
      List(4, 2)
    ))
    val input4 = Input(8, 3, List(
      List(1, 2),
      List(3, 2),
      List(4, 5),
      List(6, 7)
    ))
    val input5 = Input(6, 5, List(
      List(1, 2),
      List(3, 4),
      List(5, 6),
      List(4, 2),
      List(5, 4)
    ))
    val output = 3
    val output2 = 3
    val output3 = 3
    val output4 = 7
    val output5 = 3
    val testCases = List(
      new TestCase(input, output),
      new TestCase(input2, output2),
      new TestCase(input3, output3),
      new TestCase(input4, output4),
      new TestCase(input5, output5)
    )

    testCases.foreach(generateTest)
  }
}

case class Input(numberOfPrisoners: Int, numberOfHandcuffs: Int, handCuffedTogetherPairList: List[List[Int]])
class TestCase(input: Input, expectedOutput: Int) {
  def getInput: Input = input

  def getExpectedOutput: Int = expectedOutput
}
import org.scalatest.FunSpec

class BinarySearchTreeTest extends FunSpec {
  describe("Convert Single Digits") {
    def generateTest(testCase: TestCase): Unit = {
      it("should convert " + testCase.getInput) {
        assert(BinarySearchTree.calculateNodes(testCase.getInput.amount, testCase.getInput.nodes) == testCase.getExpectedOutput)
      }
    }
    val amount = 4
    val nodes = List(1, 2, 3, 4, 5, 6, 7)
    val input = Input(amount, nodes)
    val output = List(1, 2, 5, 14, 42, 132, 429)
    val testCases = List(new TestCase(input, output))

    testCases.foreach(generateTest)
  }
}

case class Input(amount: Int, nodes: List[Int])
class TestCase(input: Input, expectedOutput: List[Int]) {
  def getInput: Input = input

  def getExpectedOutput: List[Int] = expectedOutput
}
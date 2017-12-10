import org.scalatest.FunSpec
import BoleynSalary.Hierarchy
import BoleynSalary.Query

class BoleynSalaryTest extends FunSpec {
  describe("Convert Single Digits") {
    def generateTest(testCase: TestCase): Unit = {
      it("should convert " + testCase.getInput) {
        assert(BoleynSalary.query(testCase.getInput.hierarchies, testCase.getInput.salaries, testCase.getInput.queries) == testCase.getExpectedOutput)
      }
    }
    val nodes = List(
      Hierarchy(2, 1),
      Hierarchy(3, 2),
      Hierarchy(4, 2),
      Hierarchy(7, 4),
      Hierarchy(8, 4),
      Hierarchy(5, 1),
      Hierarchy(6, 5)
    )
    val salaries = List(70, 40, 60, 80, 10, 20, 30, 50)
    val queries = List(
      Query(2, 1),
      Query(-6, 5),
      Query(-4, 1),
      Query(-5, 3),
      Query(2, 1),
      Query(-5, 4),
      Query(2, 2)
    )
    val input = Input(nodes, salaries, queries)
    val output = List(7, 8, 7, 3, 6, 2, 8)
    val testCases = List(new TestCase(input, output))

    testCases.foreach(generateTest)
  }
}

case class Input(hierarchies: List[Hierarchy], salaries: List[Int], queries: List[Query])
class TestCase(input: Input, expectedOutput: List[Int]) {
  def getInput: Input = input

  def getExpectedOutput: List[Int] = expectedOutput
}
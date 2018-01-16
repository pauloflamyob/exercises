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

    var nodes2 = List (
      Hierarchy(2, 1),
      Hierarchy(3, 2),
      Hierarchy(4, 2),
      Hierarchy(5, 3)
    )
    val salaries2 = List(8, 3, 4, 2, 6)
    val queries2 = List(
      Query(3, 1),
      Query(-3, 2),
      Query(-1, 1),
      Query(-3, 2),
      Query(1, 1)
    )
    val input = Input(nodes, salaries, queries)
    val input2 = Input(nodes2, salaries2, queries2)
    val output = List(7, 8, 7, 3, 6, 2, 8)
    val output2 = List(5, 3, 4, 2, 5)
    val testCases = List(new TestCase(input, output), new TestCase(input2, output2))

    testCases.foreach(generateTest)
  }
}

case class Input(hierarchies: List[Hierarchy], salaries: List[Int], queries: List[Query])
class TestCase(input: Input, expectedOutput: List[Int]) {
  def getInput: Input = input

  def getExpectedOutput: List[Int] = expectedOutput
}
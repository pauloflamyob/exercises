object BoleynSalary {
  case class Query(managerId: Int, lowestSalaryPositionToLookFor: Int)
  case class Hierarchy(employeeId: Int, managerId: Int)
  case class Manager(id: Int, salary: Int)
  case class Node(leftId: Int, value: Manager, rightId: Int)

  private def getManagerIdFromQuery(queryManagerId: Int, previousManagerId: Int = 0): Int = {
    queryManagerId + previousManagerId
  }

  private def buildNodesWithManagerValuesFromHierarchies(accumulator: List[Node], hierarchy: Hierarchy): List[Node] = {
    if(accumulator(hierarchy.managerId - 1).leftId == 0) {
      return accumulator.updated(hierarchy.managerId - 1, Node(hierarchy.employeeId, accumulator(hierarchy.managerId - 1).value, accumulator(hierarchy.managerId - 1).rightId))
    }
    accumulator.updated(hierarchy.managerId - 1, Node(accumulator(hierarchy.managerId - 1).leftId, accumulator(hierarchy.managerId - 1).value, hierarchy.employeeId))
  }

  private def constructNodes(hierarchies: List[Hierarchy], salaries: List[Int]): List[Node] = {
    val initialNodes: List[Node] = salaries.indices.map(index => Node(0, Manager(index + 1, salaries(index)), 0)).toList
    hierarchies.foldLeft(initialNodes)(buildNodesWithManagerValuesFromHierarchies)
  }

  private def filterNodesOnOneSideOfTree(nodes: List[Node], filteredNodes: List[Node] = List(), nodeIndex: Int): List[Node] = {
    if(nodeIndex != -1) {
      return filterNodes(nodes, filteredNodes :+ nodes(nodeIndex), nodes(nodeIndex).value.id - 1)
    }
    filteredNodes
  }

  private def filterNodes(nodes: List[Node], filteredNodes: List[Node] = List(), nodeIndex: Int): List[Node] = {
    val newLeftFilteredNodes = filterNodesOnOneSideOfTree(nodes, filteredNodes, nodes(nodeIndex).leftId - 1)
    filterNodesOnOneSideOfTree(nodes, newLeftFilteredNodes, nodes(nodeIndex).rightId - 1)
  }

  private def addEmployeeIdToOutput(output: List[Int], salary: Int, salaryLookingFor: Int, id: Int): List[Int] =
    if (salary == salaryLookingFor) output :+ id else output


  def query(hierarchies: List[Hierarchy], salaries: List[Int], queries: List[Query]): List[Int] = {
    val nodes = constructNodes(hierarchies, salaries)

    queries.foldLeft(List(0))((output, query) => {
      val managerId = getManagerIdFromQuery(query.managerId, output.last)
      val filteredNodes = filterNodes(nodes, List(), managerId - 1)
      val salaryListOfFilteredNodes = filteredNodes.map(node => node.value.salary).sorted
      filteredNodes.foldLeft(output)(
        (outputAccumulator, node) =>
          addEmployeeIdToOutput(outputAccumulator, node.value.salary, salaryListOfFilteredNodes(query.lowestSalaryPositionToLookFor - 1), node.value.id)
      )
    }).drop(1)
  }
}
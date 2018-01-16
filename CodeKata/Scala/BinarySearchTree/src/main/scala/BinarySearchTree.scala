object BinarySearchTree {
  def calculateAmountOfBinaryTrees(nodes: List[Int]): Int = {
    var sum = 0;
    if(nodes.length > 1) {
      nodes.foreach(node => {
        var numOfNodesOnLeft = 1;
        var numOfNodesOnRight = 1;
        val leftNode = nodes.filter(_ < node)
        val rightNode = nodes.filter(_ > node)
        if (leftNode.length > 1) {
          numOfNodesOnLeft = calculateAmountOfBinaryTrees(leftNode)
        }
        if (rightNode.length > 1) {
          numOfNodesOnRight = calculateAmountOfBinaryTrees(rightNode)
        }
        sum = sum + (numOfNodesOnLeft * numOfNodesOnRight)
      })
    } else {
      sum = 1
    }
    sum
  }

  def calculateNodes(amount: Int, nodes: List[Int]): List[Int] = {
    nodes.map(numberOfNodes => calculateAmountOfBinaryTrees(List.range(1, numberOfNodes + 1)))
  }
}
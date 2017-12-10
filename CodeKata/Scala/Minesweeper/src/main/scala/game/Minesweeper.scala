package game

object Minesweeper {
  private def buildBoard(initialBoard: List[List[String]]): List[List[String]] = {
    val firstRow = initialBoard.head
    if (firstRow.isEmpty) {
      List(List())
    } else {
      val rowList = List.fill(firstRow.length)("0")
      List.fill(initialBoard.length)(rowList)
    }
  }

  private def buildFlagBoard(flagBoard: List[List[String]], row: List[String], rowIndex: Int): List[List[String]] = {
    var columnIndex: Int = 0
    var newFlagBoard = flagBoard
    row.foreach((square) => {
      if (square == "*") {
        (-1 to 1) foreach (rowNumber =>
          (-1 to 1) foreach (columnNumber =>
            newFlagBoard = updateRowAndColumn(newFlagBoard, rowIndex + rowNumber, columnIndex + columnNumber, row.length)
          )
        )
      } else if (square == "." && newFlagBoard(rowIndex)(columnIndex) == ".") {
        newFlagBoard = newFlagBoard.updated(rowIndex, newFlagBoard(rowIndex).updated(columnIndex, "0"))
      }
      columnIndex += 1
    })
    newFlagBoard
  }

  private def updateRowAndColumn(flagBoard: List[List[String]], rowIndex: Int, columnIndex: Int, maxColumnLength: Int): List[List[String]] = {
    if (rowIndex > -1 && rowIndex < flagBoard.length) {
      if (columnIndex > -1 && columnIndex < maxColumnLength) {
        return flagBoard.updated(rowIndex, flagBoard(rowIndex).updated(columnIndex, updateSquare(flagBoard(rowIndex)(columnIndex))))
      }
    }
    flagBoard
  }

  private def isAllDigits(x: String) = x forall Character.isDigit

  private def updateSquare(square: String): String = square match {
    case "." => "1"
    case "*" => "*"
    case x if isAllDigits(square) => (square.toInt + 1).toString
  }

  def generateFlags(board: List[List[String]]): List[List[String]] = {
    var flagBoard: List[List[String]] = board
    var rowIndex: Int = 0
    board.foreach((row) =>
      if (row.nonEmpty) {
        flagBoard = buildFlagBoard(flagBoard, flagBoard(rowIndex), rowIndex)
        rowIndex += 1
      }
    )
    flagBoard
  }
}

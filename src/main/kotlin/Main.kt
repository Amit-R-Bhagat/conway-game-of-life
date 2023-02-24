fun main() {
    val numberOfRows = 4
    val numberOfCols = 4
    val numberOfGenerations = 1


    val board = Board(numberOfRows, numberOfCols, createCellListFromInput(numberOfRows))
    for (generation in 0 until numberOfGenerations) {
        board.updateBoard()
    }
    printBoard(board.getCellList(), numberOfCols)
}

private fun createCellListFromInput(numberOfRows: Int): ArrayList<Cell> {
    val cellList: ArrayList<Cell> = ArrayList()

    for (row in 0 until numberOfRows) {
        val inputRow = readln().split(' ')
        for ((col, input) in inputRow.withIndex()) {
            if (input.toInt() == 1) {
                cellList.add(Cell(row, col, true))
            } else {
                cellList.add(Cell(row, col, false))
            }
        }
    }
    return cellList
}

private fun printBoard(board: ArrayList<Cell>, numberOfCols: Int) {
    var newLineCounter = 1
    for (cell in board) {
        if (cell.isAlive()) print("1 ")
        else print("0 ")
        if (newLineCounter % numberOfCols == 0) println()
        newLineCounter++
    }
}
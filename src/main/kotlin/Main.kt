fun main() {
    val board = Board(4, 4)
    board.updateBoard()
    printBoard(board.getBoard(), 4)
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
fun main() {
    val board = Board(4,4)
    board.updateBoard()
    printBoard(board.getBoard())
}

private fun printBoard(board: Array<IntArray>) {
    for (row in board) {
        for (cell in row) {
            print("$cell ")
        }
        println()
    }
}
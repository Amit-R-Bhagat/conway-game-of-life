fun main(args: Array<String>) {
    val board = getBoard()
    printBoard(board)
}

private fun getBoard(): Array<IntArray> {
    val numberOfRows = 4
    val numberOfCols = 4
    val board = Array(numberOfRows) { IntArray(numberOfCols) }
    for (row in 0 until numberOfRows) {
        var inputRow = readln().split(' ')
        for((col, input) in inputRow.withIndex()){
            board[row][col] = input.toInt()
        }
    }
    return board
}

private fun printBoard(board: Array<IntArray>) {
    for (row in board) {
        for (cell in row) {
            print("$cell ")
        }
        println()
    }
}
fun main(args: Array<String>) {
    val board = getBoard()
    updateBoard(board)
    printBoard(board)
}

fun updateBoard(board: Array<IntArray>) {
    for((rowNumber, row) in board.withIndex()){
        for((colNumber, cell) in row.withIndex()){
            var numberOfNeighbours = getNumberOfNeighbours(rowNumber, colNumber, board)

            if(board[rowNumber][colNumber]==1){
                if(numberOfNeighbours< 2 || numberOfNeighbours > 3){
                    board[rowNumber][colNumber] = 0
                }
            }else{
                if(numberOfNeighbours==3){
                    board[rowNumber][colNumber] = 1
                }
            }
        }
    }
}

fun getNumberOfNeighbours(rowNumber: Int, colNumber: Int, board: Array<IntArray>): Int {
    var neighbourCount = 0
    var rowOffsetList = listOf<Int>(0, 1, -1)
    var colOffsetList = listOf<Int>(0, 1, -1)

    for(rowOffset in rowOffsetList){
        for(colOffset in colOffsetList){
            if(rowOffset == 0 && colOffset == 0) continue
            if(isExist(rowNumber+rowOffset, colNumber+colOffset, board) && board[rowNumber][colNumber] == 1) neighbourCount++
        }
    }
    return  neighbourCount
}

fun isExist(rowNumber: Int, colNumber: Int, board: Array<IntArray>): Boolean {
    if(rowNumber >= board.size || colNumber >= board[0].size) return false
    return true
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
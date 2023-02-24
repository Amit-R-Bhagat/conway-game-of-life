class Board(numberOfRows: Int, numberOfCols: Int) {
    private var board:Array<IntArray>

    init {
        board = Array(numberOfRows) { IntArray(numberOfCols) }
        for (row in 0 until numberOfRows) {
            val inputRow = readln().split(' ')
            for((col, input) in inputRow.withIndex()){
                board[row][col] = input.toInt()
            }
        }
    }

    fun updateBoard() {
        for((rowNumber, row) in board.withIndex()){
            for((colNumber, _) in row.withIndex()){
                val numberOfNeighbours = getNumberOfNeighbours(rowNumber, colNumber, board)

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

    private fun getNumberOfNeighbours(rowNumber: Int, colNumber: Int, board: Array<IntArray>): Int {
        var neighbourCount = 0
        val rowOffsetList = listOf(0, 1, -1)
        val colOffsetList = listOf(0, 1, -1)

        for(rowOffset in rowOffsetList){
            for(colOffset in colOffsetList){
                if(rowOffset == 0 && colOffset == 0) continue
                if(isExist(rowNumber+rowOffset, colNumber+colOffset, board) && board[rowNumber][colNumber] == 1) neighbourCount++
            }
        }
        return  neighbourCount
    }

    private fun isExist(rowNumber: Int, colNumber: Int, board: Array<IntArray>): Boolean {
        if(rowNumber >= board.size || colNumber >= board[0].size) return false
        return true
    }

    fun getBoard(): Array<IntArray> {
        return board
    }

}
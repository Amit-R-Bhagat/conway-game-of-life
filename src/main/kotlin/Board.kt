class Board(private val numberOfRows: Int, private val numberOfCols: Int) {
    private var board: ArrayList<Cell> = ArrayList()

    init {
        for (row in 0 until numberOfRows) {
            val inputRow = readln().split(' ')
            for ((col, input) in inputRow.withIndex()) {
                if (input.toInt() == 1) {
                    board.add(Cell(row, col, true))
                } else {
                    board.add(Cell(row, col, false))
                }
            }
        }
    }

    fun updateBoard() {
        for (cell in board) {
            val numberOfNeighbours = getNumberOfNeighbours(cell.getRowNumber(), cell.getColNumber())
            if (cell.isAlive()) {
                if (numberOfNeighbours < 2 || numberOfNeighbours > 3) {
                    cell.toggleLiving()
                }
            } else {
                if (numberOfNeighbours == 3) {
                    cell.toggleLiving()
                }
            }
//            println("$numberOfNeighbours ${cell.getRowNumber()} ${cell.getColNumber()} ${cell.isAlive()} ${cell.toggleLiving()}")

        }
    }

    private fun getNumberOfNeighbours(rowNumber: Int, colNumber: Int): Int {
        var neighbourCount = 0
        val rowOffsetList = listOf(0, 1, -1)
        val colOffsetList = listOf(0, 1, -1)

        for (rowOffset in rowOffsetList) {
            for (colOffset in colOffsetList) {
                if (rowOffset == 0 && colOffset == 0) continue

                val row = rowNumber + rowOffset
                val col = colNumber + colOffset

                if (isExist(row, col)) {

                    if (board[row * numberOfRows + col].isAlive()) neighbourCount++
                }
            }
        }
        return neighbourCount
    }

    private fun isExist(rowNumber: Int, colNumber: Int): Boolean {
        if (rowNumber < 0 || rowNumber >= numberOfRows || colNumber >= numberOfCols || colNumber < 0) return false
        return true
    }

    fun getBoard(): ArrayList<Cell> {
        return board
    }

}
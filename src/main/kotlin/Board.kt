class Board(private val numberOfRows: Int, private val numberOfCols: Int, private val cellList: ArrayList<Cell>) {
    private val newCellList: ArrayList<Cell> = ArrayList()

    fun play(): ArrayList<Cell> {
        for (cell in cellList) {
            val numberOfNeighbours = getNumberOfAliveNeighbours(cell.getRowNumber(), cell.getColNumber())
            if ((cell.isAlive() && numberOfNeighbours < 2 || numberOfNeighbours > 3)
                || (!cell.isAlive() && numberOfNeighbours == 3)
            ) {
                newCellList.add(Cell(cell.getRowNumber(), cell.getColNumber(), cell.toggleLiving()))
            } else {
                newCellList.add(Cell(cell.getRowNumber(), cell.getColNumber(), cell.isAlive()))
            }
        }

        return newCellList
    }

    private fun getNumberOfAliveNeighbours(rowNumber: Int, colNumber: Int): Int {
        var neighbourCount = 0
        val rowOffsetList = listOf(0, 1, -1)
        val colOffsetList = listOf(0, 1, -1)

        for (rowOffset in rowOffsetList) {
            for (colOffset in colOffsetList) {
                if (rowOffset == 0 && colOffset == 0) continue

                val row = rowNumber + rowOffset
                val col = colNumber + colOffset
                if (isExist(row, col)) {
                    val neighbour = cellList[row * numberOfRows + col]
                    if (neighbour.isAlive()) neighbourCount++
                }
            }
        }
        return neighbourCount
    }

    private fun isExist(rowNumber: Int, colNumber: Int): Boolean {
        if (rowNumber < 0 || rowNumber >= numberOfRows || colNumber >= numberOfCols || colNumber < 0) return false
        return true
    }
}
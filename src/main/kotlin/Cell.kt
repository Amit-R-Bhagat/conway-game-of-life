class Cell(private val rowNumber: Int, private val colNumber: Int, private var living: Boolean) {
    fun getRowNumber(): Int {
        return rowNumber
    }

    fun getColNumber(): Int {
        return colNumber
    }

    fun isAlive(): Boolean {
        return living
    }

    fun toggleLiving(): Boolean {
        return !living
    }

}
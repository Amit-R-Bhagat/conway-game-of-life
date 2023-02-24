import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun `cell should die of underpopulation`() {
        val cellList: ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0, 0, true))
        cellList.add(Cell(0, 1, false))
        val board = Board(1, 2, cellList)

        val newCellList = board.play()

        assertEquals(false, newCellList[0].isAlive())

    }


    @Test
    fun `cell should die of overpopulation`() {
        val cellList: ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0, 0, true))
        cellList.add(Cell(0, 1, true))
        cellList.add(Cell(0, 2, true))
        cellList.add(Cell(1, 0, true))
        cellList.add(Cell(1, 1, true))
        cellList.add(Cell(1, 2, true))
        val board = Board(2, 3, cellList)

        val newCellList = board.play()

        assertEquals(false, newCellList[1].isAlive())

    }

    @Test
    fun `cell should survive if number of alive neighbours is between 2 and 3 inclusive`() {
        val cellList: ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0, 0, true))
        cellList.add(Cell(0, 1, true))
        cellList.add(Cell(0, 2, true))
        cellList.add(Cell(1, 0, true))
        cellList.add(Cell(1, 1, true))
        cellList.add(Cell(1, 2, true))
        val board = Board(2, 3, cellList)

        val newCellList = board.play()

        assertEquals(false, newCellList[1].isAlive())

    }

    @Test
    fun `cell should die due to overpopulation`() {
        val cellList: ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0, 0, true))
        cellList.add(Cell(0, 1, true))
        cellList.add(Cell(0, 2, true))
        cellList.add(Cell(1, 0, true))
        cellList.add(Cell(1, 1, true))
        cellList.add(Cell(1, 2, true))
        val board = Board(2, 3, cellList)

        val newCellList = board.play()

        assertEquals(false, newCellList[1].isAlive())

    }


    @Test
    fun `cell should become alive if number of alive neighbours exactly 3`() {
        val cellList: ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0, 0, false))
        cellList.add(Cell(0, 1, true))
        cellList.add(Cell(0, 2, true))
        cellList.add(Cell(1, 0, true))
        cellList.add(Cell(1, 1, true))
        cellList.add(Cell(1, 2, true))
        val board = Board(2, 3, cellList)

        val newCellList = board.play()

        assertEquals(true, newCellList[0].isAlive())

    }

}
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest{

    @Test
    fun `cell should die of underpopulation`(){
        var cellList:ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0,0,true))
        cellList.add(Cell(0,1, false))
        var board = Board(1, 2, cellList)

        board.updateBoard()

        assertEquals(false,board.getCellList()[0].isAlive())

    }


    @Test
    fun `cell should die of overpopulation`(){
        var cellList:ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0,0,true))
        cellList.add(Cell(0,1, true))
        cellList.add(Cell(0,2, true))
        cellList.add(Cell(1,0, true))
        cellList.add(Cell(1,1, true))
        cellList.add(Cell(1,2, true))
        var board = Board(2, 3, cellList)

        board.updateBoard()

        assertEquals(false,board.getCellList()[1].isAlive())

    }

    @Test
    fun `cell should survive if number of alive neighbours is between 2 and 3 inclusive`(){
        var cellList:ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0,0,true))
        cellList.add(Cell(0,1, true))
        cellList.add(Cell(0,2, true))
        cellList.add(Cell(1,0, true))
        cellList.add(Cell(1,1, true))
        cellList.add(Cell(1,2, true))
        var board = Board(2, 3, cellList)

        board.updateBoard()

        assertEquals(false,board.getCellList()[1].isAlive())

    }

    @Test
    fun `cell should die due to overpopulation`(){
        var cellList:ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0,0,true))
        cellList.add(Cell(0,1, true))
        cellList.add(Cell(0,2, true))
        cellList.add(Cell(1,0, true))
        cellList.add(Cell(1,1, true))
        cellList.add(Cell(1,2, true))
        var board = Board(2, 3, cellList)

        board.updateBoard()

        assertEquals(false,board.getCellList()[1].isAlive())

    }


    @Test
    fun `cell should become alive if number of alive neighbours exactly 3`(){
        var cellList:ArrayList<Cell> = ArrayList()
        cellList.add(Cell(0,0,false))
        cellList.add(Cell(0,1, true))
        cellList.add(Cell(0,2, true))
        cellList.add(Cell(1,0, true))
        cellList.add(Cell(1,1, true))
        cellList.add(Cell(1,2, true))
        var board = Board(2, 3, cellList)

        board.updateBoard()

        assertEquals(true,board.getCellList()[0].isAlive())

    }

}
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BoardTest{

    @Test
    fun `should create a board`(){
        var cellList:ArrayList<Cell> = ArrayList()
        for(row in 0 until 4){
            for(col in 0 until  4){
                cellList.add(Cell(row , col, true))
            }
        }

        var board = Board(4, 4, cellList)

        assertEquals(board.getCellList().size,16)

    }

}
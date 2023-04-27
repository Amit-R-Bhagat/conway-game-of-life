import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun `should return true if cell is alive`() {
        val cell = Cell(0, 0, true)

        assertEquals(true, cell.isAlive())
    }

    @Test
    fun `should toggle living state`() {
        val cell = Cell(0, 0, true)

        cell.toggleLiving()

        assertEquals(true, cell.isAlive())
    }
}
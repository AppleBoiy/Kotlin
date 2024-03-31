package math

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import kotlin.test.assertFailsWith

class AreaTest {
    @Test
    fun testAreaOfARectangle() = assert(areaOfARectangle(10.0, 5.0) == 50.0)

    @Test
    fun testAreaOfASquare() = assert(areaOfASquare(5.0) == 25.0)

    @Test
    fun testAreaOfACircle() = assert(areaOfACircle(1.0) == Math.PI)

    @Test
    fun testAreaOfATriangle() = assert(areaOfATriangle(5.0, 10.0) == 25.0)

    @Test
    fun testAreaWithNegatives() {
        val ex1 = Executable { areaOfARectangle(-1.0, 1.0) }
        val ex2 = Executable { areaOfASquare(-1.0) }
        val ex3 = Executable { areaOfACircle(-1.0) }
        val ex4 = Executable { areaOfATriangle(-1.0, 1.0) }

        assertFailsWith<IllegalArgumentException> {ex1.execute()}
        assertFailsWith<IllegalArgumentException> {ex2.execute()}
        assertFailsWith<IllegalArgumentException> {ex3.execute()}
        assertFailsWith<IllegalArgumentException> {ex4.execute()}
    }

    @Test
    fun testAreaWithZeros() {
        assertFailsWith<IllegalArgumentException> {
            areaOfARectangle(0.0, 1.0)
            areaOfARectangle(1.0, 0.0)
            areaOfARectangle(0.0, 0.0)
            areaOfASquare(0.0)
            areaOfACircle(0.0)
            areaOfATriangle(0.0, 1.0)
        }
    }
}

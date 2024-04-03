package sort

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TimSortKtTest {
    @Test
    fun testTimSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        timSort(array)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testTimSort2() {
        val array = arrayOf(-1, 2, 43, 3, 97, 1, 0)
        timSort(array)

        assertArrayEquals(array, arrayOf(-1, 0, 1, 2, 3, 43, 97))
    }

    @Test
    fun testTimSort3() {
        val array = arrayOf("A", "D", "E", "C", "B")
        timSort(array)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }

    @Test
    fun testTimSort4() {
        val array = arrayOf(20, 5, 16, -1)
        timSort(array)

        assertArrayEquals(array, arrayOf(-1, 5, 16, 20))
    }
}

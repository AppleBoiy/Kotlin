package dataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class NDArrayTest {
    @Test
    fun main() {
        val array = NDArray<Int>(2, 2, 2, 2)

        array[0, 0, 0, 0] = 1
        array[0, 0, 0, 1] = 2

        array[0, 0, 1, 0] = 3
        array[0, 0, 1, 1] = 4

        val expected = "[[[[1, 2], [3, 4]], [[0, 0], [0, 0]]], [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]]"
        assertEquals(expected, array.toString())
    }

}

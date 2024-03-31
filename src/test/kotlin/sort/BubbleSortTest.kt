package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class BubbleSortTest {
    @Test
    fun testBubbleSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        bubbleSort(array)

        Assertions.assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testBubbleSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        bubbleSort(array)

        Assertions.assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }
}

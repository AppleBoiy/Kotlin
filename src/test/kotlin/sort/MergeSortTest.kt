package sort

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertArrayEquals

class MergeSortTest {
    @Test
    fun testMergeSort1() {
        val array = arrayOf(4, 3, 2, 8, 1)
        mergeSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf(1, 2, 3, 4, 8))
    }

    @Test
    fun testMergeSort2() {
        val array = arrayOf("A", "D", "E", "C", "B")
        mergeSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf("A", "B", "C", "D", "E"))
    }

    @Test
    fun testMergeSort3() {
        val array = arrayOf(20, 5, 16, -1)
        mergeSort(array, 0, array.size - 1)

        assertArrayEquals(array, arrayOf(-1, 5, 16, 20))
    }
}

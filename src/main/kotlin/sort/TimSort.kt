package sort


/**
 * This method implements the Tim Sort algorithm which is based on Merge Sort and Insertion Sort
 *
 * - Worst-case performance	O(n*log(n))
 * - Best-case performance	O(n)
 * - Average performance	    O(n*log(n))
 * - Worst-case space complexity	O(n)
 *
 * @param array The array to be sorted
 * @see <a href="https://en.wikipedia.org/wiki/Timsort">Tim Sort</a>
 */
fun <T : Comparable<T>> timSort(array: Array<T>) {
    val n = array.size
    val minRun = minRunLength(n)

    for (i in 0 until n step minRun) {
        insertionSort(array, i, minOf(i + minRun, n))
    }

    var size = minRun
    while (size < n) {
        for (i in 0 until n step 2 * size) {
            val mid = i + size
            val end = minOf(i + 2 * size, n)
            merge(array, i, mid, end)
        }
        size *= 2
    }
}

/**
 * This method calculates the minimum run length
 *
 * @param n The size of the array
 * @return The minimum run length
 */
private fun minRunLength(n: Int): Int {
    var r = 0
    var n = n
    while (n >= 64) {
        r = r or (n and 1)
        n = n shr 1
    }
    return n + r
}

/**
 * This method implements the Generic Insertion Sort
 *
 * @param array The array to be sorted
 * @param left The left index of the array
 * @param right The right index of the array
 * Sorts the array in increasing order
 */
fun <T : Comparable<T>> insertionSort(array: Array<T>, left: Int, right: Int) {
    for (i in left + 1 until right) {
        val key = array[i]
        var j = i - 1

        while (j >= left && array[j] > key) {
            array[j + 1] = array[j]
            j--
        }

        array[j + 1] = key
    }
}

/**
 * This method merges two sorted arrays
 *
 * @param array The array to be sorted
 * @param left The left index of the array
 * @param mid The middle index of the array
 * @param right The right index of the array
 */
fun <T : Comparable<T>> merge(array: Array<T>, left: Int, mid: Int, right: Int) {
    val leftArray = array.copyOfRange(left, mid)
    val rightArray = array.copyOfRange(mid, right)

    var i = 0
    var j = 0
    var k = left

    while (i < leftArray.size && j < rightArray.size) {
        if (leftArray[i] <= rightArray[j]) {
            array[k++] = leftArray[i++]
        } else {
            array[k++] = rightArray[j++]
        }
    }

    while (i < leftArray.size) {
        array[k++] = leftArray[i++]
    }

    while (j < rightArray.size) {
        array[k++] = rightArray[j++]
    }
}

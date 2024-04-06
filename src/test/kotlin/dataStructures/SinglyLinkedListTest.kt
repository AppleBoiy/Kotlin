package dataStructures

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class NodeSinglyTest {

    companion object {
        private lateinit var node: Node<Int>

        @BeforeAll
        @JvmStatic
        fun setup() {
            node = Node(1)
        }
    }

    @Test
    fun testNode() {
        assertEquals(1, node.data)
    }

    @Test
    fun testNodeNext() {
        node.next = Node(2)
        assertEquals(2, node.next?.data)
    }

    @Test
    fun testNodeNextNext() {
        node.next = Node(2)
        assertEquals(null, node.next?.next)
    }

    @Test
    fun testNodeCopy() {
        val copy = node.copy()
        assertEquals(1, copy.data)
        assertEquals(node, copy)
    }

    @Test
    fun testNodeToString() {
        assertEquals("Node(1)", node.toString())
    }
}

class SinglyLinkedListTest {

    @Nested
    inner class TestCompanion {
        @Test
        fun testFromArray() {
            val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3))
            assertEquals("[1, 2, 3]", list.toString())
        }

        @Test
        fun testFromArrayString() {
            val list1 = SinglyLinkedList.fromArray(arrayOf("aa", "ab", "ac"))
            val list2 = SinglyLinkedList.fromArray(arrayOf("bc", "ba", "bb"))

            assertEquals("[bc, ba, bb]", list2.toString())
            list2.sort { a, b -> a.compareTo(b) }

            assertEquals("[aa, ab, ac]", list1.toString())
            assertEquals("[ba, bb, bc]", list2.toString())
        }

        @Test
        fun testFromArrayChar() {
            val list = SinglyLinkedList.fromArray(arrayOf('a', 'b', 'c'))
            assertEquals("[a, b, c]", list.toString())
        }

        @Test
        fun testFromArrayDouble() {
            val list = SinglyLinkedList.fromArray(arrayOf(1.0, 2.0, 3.0))
            assertEquals("[1.0, 2.0, 3.0]", list.toString())
        }

        @Test
        fun testFromRange() {
            val list = SinglyLinkedList.fromRange(1..3)
            assertEquals("[1, 2, 3]", list.toString())
        }
    }

    @Nested
    inner class TestFromList {
        @Test
        fun testFromList() {
            val list = SinglyLinkedList.fromList(listOf(1, 2, 3))
            assertEquals("[1, 2, 3]", list.toString())
        }
    }

    @Nested
    inner class TestFromString {
        @Test
        fun testFromStringInt() {
            val list = SinglyLinkedList.fromString<Int>("123")
            assertEquals("[1, 2, 3]", list.toString())
        }

        @Test
        fun testFromStringChar() {
            val list = SinglyLinkedList.fromString<Char>("abc")
            assertEquals("[a, b, c]", list.toString())
        }
    }

    @Nested
    inner class TestInsert {
        @Test
        fun testInsert() {
            val list = SinglyLinkedList.fromArray(arrayOf(1, 3))
            list.insert(1, 2)
            assertEquals("[1, 2, 3]", list.toString())
        }

        @Test
        fun testInsertThrows() {
            val list = SinglyLinkedList.fromArray(arrayOf(1, 2))
            assertThrows(IndexOutOfBoundsException::class.java) { list.insert(3, 3) }
        }
    }

    @Nested
    inner class TestSort {
        @Test
        fun testSortInt() {
            list.append(3)
            list.append(2)
            list.append(1)
            // Requires Comparator
            list.sort { a, b -> a - b }
            assertEquals("[1, 2, 3]", list.toString())
        }

        @Test
        fun testSortString() {
            val list = SinglyLinkedList<String>()
            list.append("c")
            list.append("b")
            list.append("a")
            // Requires Comparator
            list.sort { a, b -> a.compareTo(b) }
            assertEquals("[a, b, c]", list.toString())
        }

        @Test
        fun testSortChar() {
            val list = SinglyLinkedList<Char>()
            list.append('c')
            list.append('b')
            list.append('a')
            // Requires Comparator
            list.sort { a, b -> a.compareTo(b) }
            assertEquals("[a, b, c]", list.toString())
        }

        @Test
        fun testSortDouble() {
            val list = SinglyLinkedList<Double>()
            list.append(3.0)
            list.append(2.0)
            list.append(1.0)
            // Requires Comparator
            list.sort { a, b -> a.compareTo(b) }
            assertEquals("[1.0, 2.0, 3.0]", list.toString())
        }

        @Test
        fun testSortedInt() {
            list.append(3)
            list.append(2)
            list.append(1)
            val sortedList = SinglyLinkedList.sorted(list)
            assertEquals("[1, 2, 3]", sortedList.toString())
        }

        @Test
        fun testSortedString() {
            val list = SinglyLinkedList<String>()
            list.append("c")
            list.append("b")
            list.append("a")
            val sortedList = SinglyLinkedList.sorted(list)
            assertEquals("[a, b, c]", sortedList.toString())
        }

        @Test
        fun testSortedChar() {
            val list = SinglyLinkedList<Char>()
            list.append('c')
            list.append('b')
            list.append('a')
            val sortedList = SinglyLinkedList.sorted(list)
            assertEquals("[a, b, c]", sortedList.toString())
        }

        @Test
        fun testSortedDouble() {
            val list = SinglyLinkedList<Double>()
            list.append(3.0)
            list.append(2.0)
            list.append(1.0)
            val sortedList = SinglyLinkedList.sorted(list)
            assertEquals("[1.0, 2.0, 3.0]", sortedList.toString())
        }
    }

    @Nested
    inner class TestPop {
        @Test
        fun testPop() {
            list.append(1)
            list.append(2)
            list.append(3)
            assertEquals(3, list.pop())
            assertEquals("[1, 2]", list.toString())
        }

        @Test
        fun testPopEmpty() {
            assertThrows(NoSuchElementException::class.java) { list.pop() }
        }
    }

    @Nested
    inner class TestOperator {
        @Test
        fun testPlusWithAnotherList() {
            val list1 = SinglyLinkedList.fromArray(arrayOf(1, 2))
            val list2 = SinglyLinkedList.fromArray(arrayOf(3, 4))
            val list3 = list1 + list2
            assertEquals("[1, 2, 3, 4]", list3.toString())
        }

        @Test
        fun testPlusAssignWithAnotherList() {
            val list1 = SinglyLinkedList.fromArray(arrayOf(1, 2))
            list1 += SinglyLinkedList.fromArray(arrayOf(3, 4))
            assertEquals("[1, 2, 3, 4]", list1.toString())
        }

        @Test
        fun testTimes() {
            val list = SinglyLinkedList.fromArray(arrayOf(1, 2))
            val newList = list * 3
            assertEquals("[1, 2, 1, 2, 1, 2]", newList.toString())
        }

        @Test
        fun testTimesAssign() {
            val list = SinglyLinkedList.fromArray(arrayOf(1, 2))
            list *= 3
            assertEquals("[1, 2, 1, 2, 1, 2]", list.toString())
        }
    }

    companion object {
        private lateinit var node: Node<Int>
        private lateinit var list: SinglyLinkedList<Int>

        @BeforeAll
        @JvmStatic
        fun setup() {
            list = SinglyLinkedList()

            node = Node(1)
            node.next = Node(2)

            assertEquals(1, node.data)
            assertEquals(2, node.next?.data)
        }
    }

    @BeforeEach
    fun init() {
        list.clear()
    }

    @Test
    fun testIsEmpty() {
        assertEquals(true, list.isEmpty())
        list.append(1)
        assertEquals(false, list.isEmpty())
    }

    @Test
    fun testAppend() {
        list.append(1) // [1]
        assertEquals("[1]", list.toString())

        list.append(2) // [1, 2]
        assertEquals("[1, 2]", list.toString())
    }

    @Test
    fun testClear() {
        list.append(1) // [1]
        list.append(2) // [1, 2]
        list.clear() // []
        assertEquals(0, list.length)
    }

    @Test
    fun testGet() {
        list.append(1) // [1]
        list.append(2) // [1, 2]
        assertEquals(1, list[0].data)
        assertEquals(2, list[1].data)
    }

    @Test
    fun testRemove() {
        list.append(1) // [1]
        list.append(2) // [1, 2]
        list.append(3) // [1, 2, 3]
        list.remove(1) // [1, 3]
        assertEquals(3, list[1].data)
    }

    @Test
    fun testFind() {
        list.append(1) // [1]
        list.append(2) // [1, 2]
        list.append(3) // [1, 2, 3]
        assertEquals(0, list.find(1))
        assertEquals(-1, list.find(4))
    }

    @Test
    fun testPush() {
        list.push(1) // [1]
        assertEquals(1, list[0].data)

        list.push(2) // [2, 1]
        assertEquals("[2, 1]", list.toString())
    }

    @Test
    fun testLength() {
        assertEquals(0, list.length)

        list.append(1)
        assertEquals(1, list.length)

        list.append(2)
        assertEquals(2, list.length)
    }

    @Test
    fun testReverse() {
        list.append(1)
        list.append(2)
        list.append(3)
        list.reverse()
        assertEquals("[3, 2, 1]", list.toString())
    }

    @Test
    fun testReverseEmpty() {
        list.reverse()
        assertEquals("[]", list.toString())
    }

    @Test
    fun testReverseSingle() {
        list.append(1)
        list.reverse()
        assertEquals("[1]", list.toString())
    }

    @Test
    fun testReverseDouble() {
        list.append(1)
        list.append(2)
        list.reverse()
        assertEquals("[2, 1]", list.toString())
    }

    @Test
    fun testEquals() {
        list.append(1)
        list.append(2)
        val list2 = SinglyLinkedList<Int>()
        list2.append(1)
        list2.append(2)
        assertEquals(list, list2)
    }

    @Test
    fun testCopy() {
        list.append(1)
        list.append(2)
        val newList = list.copy()
        assertEquals("[1, 2]", newList.toString())
    }

    @Test
    fun testToString() {
        list.append(1)
        list.append(2)
        assertEquals("[1, 2]", list.toString())
    }

    @Test
    fun testApply() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2))
        list.apply { it.data += 1 }
        assertEquals("[2, 3]", list.toString())
    }

    @Test
    fun testApplyEmpty() {
        val list = SinglyLinkedList<Int>()
        list.apply { it.data += 1 }
        assertEquals("[]", list.toString())
    }

    @Test
    fun testApplyString() {
        val list = SinglyLinkedList.fromArray(arrayOf("a", "b"))
        list.apply { it.data = it.data.uppercase() }
        assertEquals("[A, B]", list.toString())
    }

    @Test
    fun testIterator() {
        list.append(1)
        list.append(2)
        val iterator = list.iterator()
        assertEquals(1, iterator.next().data)
        assertEquals(2, iterator.next().data)
    }

    @Test
    fun testForLoopThroughItem() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3))
        var i = 1
        for (node in list) {
            assertEquals(i, node.data)
            i++
        }
    }

    @Test
    fun testForLoopThroughIndex() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3))
        for (i in 0 until list.length) {
            assertEquals(i + 1, list[i].data)
        }
    }

    @Test
    fun testForLoopThroughIndexWithStep() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3, 4, 5))
        for (i in 0 until list.length step 2) {
            assertEquals(i + 1, list[i].data)
        }
    }

    @Test
    fun testForLoopThroughIndices() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3))
        for (i in list.indices) {
            assertEquals(i + 1, list[i].data)
        }
    }

    @Test
    fun testFilter() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3, 4, 5))
        val filteredList = list.filter { it.data % 2 == 0 }
        assertEquals("[2, 4]", filteredList.toString())
    }

    @Test
    fun testFilterString() {
        val list = SinglyLinkedList.fromArray(arrayOf("a", "asb", "abc", "abcd", "abcde"))
        val filteredList = list.filter { it.data.length == 3 }
        assertEquals("[asb, abc]", filteredList.toString())
    }
}

package dataStructures

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

class SinglyLinkedListTest {

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
    fun testNode() {
        assertEquals(1, node.data)
        assertEquals(2, node.next?.data)
    }

    @Test
    fun testNodeNext() {
        assertEquals(2, node.next?.data)
    }

    @Test
    fun testNodeNextNext() {
        assertEquals(null, node.next?.next)
    }

    @Test
    fun testIsEmpty() {
        assertEquals(true, list.isEmpty())
        list.append(1)
        assertEquals(false, list.isEmpty())
    }

    @Test
    fun testFromArray() {
        val list = SinglyLinkedList.fromArray(arrayOf(1, 2, 3))
        assertEquals("[1, 2, 3]", list.toString())
    }

    @Test
    fun testFromList() {
        val list = SinglyLinkedList.fromList(listOf(1, 2, 3))
        assertEquals("[1, 2, 3]", list.toString())
    }

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
    fun testInsert() {
        list.append(1) // [1]
        list.append(3) // [1, 3]
        list.insert(1, 2)
        assertEquals(2, list[1].data)
    }

    @Test
    fun testInsertThrows() {
        list.append(1) // [1]
        list.append(2) // [1, 2]
        assertThrows(IndexOutOfBoundsException::class.java) {
            list.insert(3, 3)
        }
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
    fun testPrepend() {
        list.prepend(1)  // [1]
        assertEquals(1, list[0].data)

        list.prepend(2)
        assertEquals(2, list[0].data)
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
}

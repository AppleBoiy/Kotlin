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
    fun testToString() {
        list.append(1)
        list.append(2)
        assertEquals("[1, 2]", list.toString())
    }
}

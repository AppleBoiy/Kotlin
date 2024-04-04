package dataStructures

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll

class SinglyLinkedListTest {
    companion object {
        @JvmStatic
        @BeforeAll
        fun setUp() {
            val singlyLinkedList = SinglyLinkedList()
            singlyLinkedList.insert(1)
            singlyLinkedList.insert(2)
            singlyLinkedList.insert(3)

            assertEquals("1 2 3", singlyLinkedList.toString())
        }
    }

    @Test
    fun insert() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        assertEquals("1 2 3", singlyLinkedList.toString())
    }

    @Test
    fun insertAtIndex() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        singlyLinkedList.insert(4, 1)

        assertEquals("1 4 2 3", singlyLinkedList.toString())
    }

    @Test
    fun delete() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        singlyLinkedList.delete(2)

        assertEquals("1 3", singlyLinkedList.toString())
    }

    @Test
    fun search() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        assertEquals(1, singlyLinkedList.search(2))
    }

    @Test
    fun searchNotFound() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        assertEquals(-1, singlyLinkedList.search(4))
    }

    @Test
    fun reverse() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        singlyLinkedList.reversed()

        assertEquals("3 2 1", singlyLinkedList.toString())
    }

    @Test
    fun sort() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(3)
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)

        singlyLinkedList.sorted()

        assertEquals("1 2 3", singlyLinkedList.toString())
    }

    @Test
    fun length() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        assertEquals(3, singlyLinkedList.length)
    }

    @Test
    fun copy() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        val copiedList = singlyLinkedList.copy()

        assertEquals("1 2 3", copiedList.toString())
    }

    @Test
    fun pop() {
        val singlyLinkedList = SinglyLinkedList()
        singlyLinkedList.insert(1)
        singlyLinkedList.insert(2)
        singlyLinkedList.insert(3)

        val popped = singlyLinkedList.pop()

        assertEquals("2 3", singlyLinkedList.toString())
        assertEquals(1, popped)
    }
}

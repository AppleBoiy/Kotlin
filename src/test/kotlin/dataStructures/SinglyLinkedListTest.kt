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

        assertTrue(singlyLinkedList.search(2))
    }
}

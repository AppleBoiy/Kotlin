package dataStructures

interface Node<T> {
    val value: T
    var next: Node<T>?
}

/**
 * Singly Linked List is a data structure consisting of a group of nodes which together represent a sequence.
 * Each node contains two fields: a value and a reference to the next node in the sequence.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Linked_list">Linked List (Wikipedia)</a>
 */
class SinglyLinkedList {
    private var head: Node<Int>? = null

    /**
     * Insert a new node with the given value at the end of the linked list
     * @param value The value to be inserted
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.insert
     */
    fun insert(value: Int) {
        val newNode = object : Node<Int> {
            override val value = value
            override var next: Node<Int>? = null
        }

        if (head == null) {
            head = newNode
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    /**
     * Delete the node with the given value from the linked list
     * @param value The value to be deleted
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.delete
     */
    fun delete(value: Int) {
        if (head == null) {
            return
        }

        if (head?.value == value) {
            head = head?.next
            return
        }

        var current = head
        while (current?.next != null) {
            if (current.next?.value == value) {
                current.next = current.next?.next
                return
            }
            current = current.next
        }
    }

    /**
     * Search for the node with the given value in the linked list
     * @param value The value to be searched
     * @return true if the value is found, false otherwise
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.search
     */
    fun search(value: Int): Boolean {
        var current = head
        while (current != null) {
            if (current.value == value) {
                return true
            }
            current = current.next
        }
        return false
    }


    /**
     * @return string representation of the linked list
     */
    override fun toString(): String {
        var current = head
        var str = ""
        while (current != null) {
            str += "${current.value} "
            current = current.next
        }
        return str.trim()
    }
}

package dataStructures

interface Node<T> {
    var value: T
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

    val length: Int
        get() {
            var current = head
            var count = 0
            while (current != null) {
                count++
                current = current.next
            }
            return count
        }

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
            override var value = value
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
     * Insert a new node with the given value at the given index in the linked list
     * @param value The value to be inserted
     * @param index The index at which the value should be inserted
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @sample dataStructures.SinglyLinkedListTest.insertAtIndex
     */
    fun insert(value: Int, index: Int) {
        if (index < 0 || index > length) {
            throw IndexOutOfBoundsException("Index: $index, Length: $length")
        }

        val newNode = object : Node<Int> {
            override var value = value
            override var next: Node<Int>? = null
        }

        if (index == 0) {
            newNode.next = head
            head = newNode
        } else {
            var current = head
            var i = 0
            while (i < index - 1) {
                current = current?.next
                i++
            }
            newNode.next = current?.next
            current?.next = newNode
        }
    }

    /**
     * Delete first node from the linked list and return its value
     *
     * @return the value of the deleted node
     * @throws NoSuchElementException if the linked list is empty
     * @sample dataStructures.SinglyLinkedListTest.pop
     */
    fun pop(): Int {
        if (head == null) {
            throw NoSuchElementException("Linked list is empty")
        }

        val value = head!!.value
        head = head!!.next
        return value
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
     * @return index of the value returned if found, -1 otherwise
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.search
     */
    fun search(value: Int): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (current.value == value) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    /**
     * Reverse the linked list
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.reverse
     */
    fun reversed() {
        var prev: Node<Int>? = null
        var current = head
        var next: Node<Int>?
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }

    /**
     * Sort the linked list
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     * @sample dataStructures.SinglyLinkedListTest.sort
     */
    fun sorted() {
        var current = head
        var index: Node<Int>?
        var temp: Int
        while (current != null) {
            index = current.next
            while (index != null) {
                if (current.value > index.value) {
                    temp = current.value
                    current.value = index.value
                    index.value = temp
                }
                index = index.next
            }
            current = current.next
        }
    }

    /**
     * Copy the linked list
     * @return a new linked list with the same values
     * @sample dataStructures.SinglyLinkedListTest.copy
     */
    fun copy(): SinglyLinkedList {
        val newList = SinglyLinkedList()
        var current = head
        while (current != null) {
            newList.insert(current.value)
            current = current.next
        }
        return newList
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

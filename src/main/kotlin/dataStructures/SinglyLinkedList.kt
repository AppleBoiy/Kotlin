package dataStructures


/**
 * Node class for Singly Linked List
 *
 * @param T the type of the data
 * @property data the data of the node
 * @property next the next node
 * @constructor Creates a node with the data and the next node
 *
 * @see SinglyLinkedList
 */
class Node<T>(var data: T, var next: Node<T>? = null) {

    fun copy(): Node<T> {
        return Node(data, next?.copy())
    }

    override fun toString(): String {
        return "Node(data=$data, next=$next)"
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node<*>

        if (data != other.data) return false
        if (next != other.next) return false

        return true
    }

    operator fun compareTo(other: Node<T>): Int {
        return this.data.toString().compareTo(other.data.toString())
    }

    operator fun compareTo(other: T): Int {
        return this.data.toString().compareTo(other.toString())
    }
}


/**
 * Singly Linked List implementation
 *
 * @param T the type of the data
 * @property head the head of the list
 * @property length the length of the list
 * @constructor Creates an empty list
 *
 * @see Node
 */
class SinglyLinkedList<T> {
    private var head: Node<T>? = null

    val length : Int
        get() {
            var current = head
            var count = 0
            while (current != null) {
                count++
                current = current.next
            }
            return count
        }

    companion object {

        /**
         * Sort the list in ascending order without modifying the original list
         * @return the sorted list
         * @sample dataStructures.SinglyLinkedListTest.testSortedInt
         */
        fun <T> sorted(list: SinglyLinkedList<T>): SinglyLinkedList<T> {
            val newList = list.copy()
            newList.sort { o1, o2 -> o1.toString().compareTo(o2.toString()) }
            return newList
        }

        /**
         * Create a Singly Linked List from a list
         * @param list the list to create the linked list
         * @return the linked list
         * @sample dataStructures.SinglyLinkedListTest.testFromList
         */
        fun <T> fromList(list: List<T>): SinglyLinkedList<T> {
            val linkedList = SinglyLinkedList<T>()
            list.forEach { linkedList.append(it) }
            return linkedList
        }

        /**
         * Create a Singly Linked List from an array
         * @param array the array to create the linked list
         * @return the linked list
         * @sample dataStructures.SinglyLinkedListTest.testFromArray
         */
        fun <T> fromArray(array: Array<T>): SinglyLinkedList<T> {
            val linkedList = SinglyLinkedList<T>()
            array.forEach { linkedList.append(it) }
            return linkedList
        }

        /**
         * Create a Singly Linked List from a string
         * @param string the string to create the linked list
         * @return the linked list
         * @throws ClassCastException if the type is not matched
         *
         * @sample dataStructures.SinglyLinkedListTest.testFromStringInt
         * @sample dataStructures.SinglyLinkedListTest.testFromStringChar
         */
        fun <T> fromString(string: String): SinglyLinkedList<T> {
            val linkedList = SinglyLinkedList<T>()
            @Suppress("UNCHECKED_CAST")
            string.forEach { linkedList.append(it as T) }
            return linkedList
        }
    }


    /**
     * Check if the list is empty
     * @return whether the list is empty or not
     *
     * @sample dataStructures.SinglyLinkedListTest.testIsEmpty
     */
    fun isEmpty(): Boolean {
        return head == null
    }

    /**
     * Find the index of a specific data
     * @param data the data to find
     * @return the index of the data, -1 if not found
     * @sample dataStructures.SinglyLinkedListTest.testFind
     */
    fun find(data: T): Int {
        var current = head
        var index = 0
        while (current != null) {
            if (current.data == data) {
                return index
            }
            current = current.next
            index++
        }
        return -1
    }

    /**
     * Clear the list by setting the head to null and freeing the memory
     * @sample dataStructures.SinglyLinkedListTest.testClear
     */
    fun clear() {
        head = null
    }

    /**
     * Append data to the end of the list
     * @param data the data to append
     * @sample dataStructures.SinglyLinkedListTest.testAppend
     */
    fun append(data: T) {
        if (head == null) {
            head = Node(data)
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = Node(data)
    }


    /**
     * Append node to the end of the list
     * @param node the data to append
     */
    fun append(node: Node<T>) {
        if (head == null) {
            head = node
            return
        }
        var current = head
        while (current?.next != null) {
            current = current.next
        }
        current?.next = node
    }


    /**
     * Prepend data to the beginning of the list
     * @param data the data to prepend
     * @sample dataStructures.SinglyLinkedListTest.testPrepend
     */
    fun prepend(data: T) {
        head = Node(data, head)
    }


    /**
     * Remove data at a specific index
     * @param index the index to remove the data
     * @throws IndexOutOfBoundsException if the index is out of bounds
     * @sample dataStructures.SinglyLinkedListTest.testRemove
     */
    fun remove(index: Int) {
        if (index < 0 || index >= length) {
            throw IndexOutOfBoundsException("List has length $length, cannot remove at index $index")
        }
        if (index == 0) {
            head = head?.next
            return
        }
        var current = head
        var i = 0
        while (i < index - 1) {
            current = current?.next
            i++
        }
        current?.next = current?.next?.next
    }

    /**
     * Insert data at a specific index
     * @param index the index to insert the data
     * @param data the data to insert
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    fun insert(index: Int, data: T) {
        if (index < 0 || index > length) {
            throw IndexOutOfBoundsException("List has length $length, cannot insert at index $index")
        }

        if (index == 0) {
            prepend(data)
            return
        }
        var current = head
        var i = 0
        while (i < index - 1) {
            current = current?.next
            i++
        }
        current?.next = Node(data, current?.next)
    }


    /**
     * Copy the list
     * @return the copied list
     * @sample dataStructures.SinglyLinkedListTest.testCopy
     */
    fun copy(): SinglyLinkedList<T> {
        val newList = SinglyLinkedList<T>()
        var current = head
        while (current != null) {
            newList.append(current.data)
            current = current.next
        }
        return newList
    }


    /**
     * Sort the list in ascending order
     * @param comparator the comparator to compare the data
     * @sample dataStructures.SinglyLinkedListTest.testSortInt
     * @sample dataStructures.SinglyLinkedListTest.testSortString
     */
    fun sort(comparator: Comparator<T>) {
        if (head == null) {
            return
        }
        var current = head
        while (current != null) {
            var next = current.next
            while (next != null) {
                if (comparator.compare(current.data, next.data) > 0) {
                    val temp = current.data
                    current.data = next.data
                    next.data = temp
                }
                next = next.next
            }
            current = current.next
        }
    }

    /**
     * Get the data at a specific index
     * @param index the index to get the data
     * @return node at the index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    operator fun get(index: Int): Node<T> {
        if (index < 0 || index >= length) {
            throw IndexOutOfBoundsException("Index $index is out of bounds")
        }
        var current = head
        repeat(index) {
            current = current?.next
        }
        return current!!
    }


    /**
     * String representation of the list
     * @return the string representation of the list
     * @sample dataStructures.SinglyLinkedListTest.testToString
     */
    override fun toString(): String {
        var current = head
        val sb = StringBuilder()
        sb.append("[")
        while (current != null) {
            sb.append(current.data)
            if (current.next != null) {
                sb.append(", ")
            }
            current = current.next
        }
        sb.append("]")
        return sb.toString()
    }
}

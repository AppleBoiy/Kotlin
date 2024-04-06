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

    /**
     * String representation of the node
     * @return the string representation of the node
     * @sample dataStructures.NodeSinglyTest.testNodeToString
     */
    override fun toString(): String {
        return "Node($data)"
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result = 31 * result + (next?.hashCode() ?: 0)
        return result
    }

    /**
     * Check if the node is equal to another node
     * @param other the other node to compare
     * @return whether the nodes are equal or not
     * @sample dataStructures.NodeSinglyTest.testNode
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Node<*>

        return data == other.data
    }

    /**
     * Compare the node to another node
     * @param other the other node to compare
     * @return the comparison result
     */
    operator fun compareTo(other: Node<T>): Int {
        return this.data.toString().compareTo(other.data.toString())
    }

    /**
     * Compare the node to another data
     * @param other the other data to compare
     * @return the comparison result
     */
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

    val indices: IntRange
        get() = 0 until length

    companion object {

        /**
         * Sort the list in ascending order without modifying the original list
         * @return the sorted list
         * @sample dataStructures.SinglyLinkedListTest.TestSort.testSortInt
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
         * @sample dataStructures.SinglyLinkedListTest.TestFromList.testFromList
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
         * @sample dataStructures.SinglyLinkedListTest.TestCompanion.testFromArray
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
         * @sample dataStructures.SinglyLinkedListTest.TestFromString.testFromStringInt
         */
        fun <T> fromString(string: String): SinglyLinkedList<T> {
            val linkedList = SinglyLinkedList<T>()
            @Suppress("UNCHECKED_CAST")
            string.forEach { linkedList.append(it as T) }
            return linkedList
        }

        /**
         * Create a Singly Linked List from a range
         * @param range the range to create the linked list
         * @return the linked list
         * @sample dataStructures.SinglyLinkedListTest.TestCompanion.testFromRange
         */
        fun fromRange(range: IntRange): SinglyLinkedList<Int> {
            val linkedList = SinglyLinkedList<Int>()
            range.forEach { linkedList.append(it) }
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
     * @sample dataStructures.SinglyLinkedListTest.testPush
     */
    fun push(data: T) {
        head = Node(data, head)
    }

    /**
     * Remove the last node of the list and return the data
     * @return the data of the last node
     * @throws NoSuchElementException if the list is empty
     * @sample dataStructures.SinglyLinkedListTest.testPop
     */
    fun pop(): T {
        if (head == null) {
            throw NoSuchElementException("List is empty")
        }
        if (head?.next == null) {
            val data = head?.data
            head = null
            return data!!
        }
        var current = head
        while (current?.next?.next != null) {
            current = current.next
        }
        val data = current?.next?.data
        current?.next = null
        return data!!
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
     * @sample dataStructures.SinglyLinkedListTest.TestInsert.testInsert
     */
    fun insert(index: Int, data: T) {
        if (index < 0 || index > length) {
            throw IndexOutOfBoundsException("List has length $length, cannot insert at index $index")
        }

        if (index == 0) {
            push(data)
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
     * @sample dataStructures.SinglyLinkedListTest.TestSort.testSortInt
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
     * Reverse the list
     * @sample dataStructures.SinglyLinkedListTest.testReverse
     */
    fun reverse() {
        var prev: Node<T>? = null
        var current = head
        var next: Node<T>?
        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next
        }
        head = prev
    }

    /**
     * apply the function to each element of the list
     * @param func the function to apply
     * @sample dataStructures.SinglyLinkedListTest.testApply
     */
    fun apply(func: (Node<T>) -> Unit) {
        var current = head
        while (current != null) {
            func(current)
            current = current.next
        }
    }

    /**
     * Filter the list with the predicate
     * @param predicate the predicate to filter the list
     * @return the filtered list
     * @sample dataStructures.SinglyLinkedListTest.testFilter
     */
    fun filter(predicate: (Node<T>) -> Boolean): SinglyLinkedList<T> {
        val newList = SinglyLinkedList<T>()
        var current = head
        while (current != null) {
            if (predicate(current)) {
                newList.append(current.data)
            }
            current = current.next
        }
        return newList
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
     * + operator to append a list to the list
     * @param list the list to append
     * @sample dataStructures.SinglyLinkedListTest.TestOperator.testPlusWithAnotherList
     */
    operator fun plus(list: SinglyLinkedList<T>): SinglyLinkedList<T> {
        val newList = copy()
        var current = list.head
        while (current != null) {
            newList.append(current.data)
            current = current.next
        }
        return newList
    }

    /**
     * += operator to append a list to the list
     * @param list the list to append
     * @sample dataStructures.SinglyLinkedListTest.TestOperator.testPlusAssignWithAnotherList
     */
    operator fun plusAssign(list: SinglyLinkedList<T>) {
        var current = list.head
        while (current != null) {
            append(current.data)
            current = current.next
        }
    }

    /**
     * * operator to repeat the list
     * @param times the number of times to repeat
     * @sample dataStructures.SinglyLinkedListTest.TestOperator.testTimes
     * @throws IllegalArgumentException if the times is less than 0
     * @return the repeated list
     */
    operator fun times(times: Int): SinglyLinkedList<T> {
        if (times < 0) {
            throw IllegalArgumentException("Times should be greater than or equal to 0")
        }
        val newList = copy()
        repeat(times - 1) {
            newList += copy()
        }
        return newList
    }

    /**
     * *= operator to repeat the list
     * @param times the number of times to repeat
     * @sample dataStructures.SinglyLinkedListTest.TestOperator.testTimesAssign
     * @throws IllegalArgumentException if the times is less than 0
     */
    operator fun timesAssign(times: Int) {
        if (times < 0) {
            throw IllegalArgumentException("Times should be greater than or equal to 0")
        }
        val current = copy()
        repeat(times - 1) {
            this += current
        }
    }

    /**
     * Convert the list to an iterator
     * @return the iterator of the list
     * @sample dataStructures.SinglyLinkedListTest.testIterator
     */
    operator fun iterator(): Iterator<Node<T>> {
        return object : Iterator<Node<T>> {
            var current = head
            override fun hasNext(): Boolean {
                return current != null
            }

            override fun next(): Node<T> {
                val node = current
                current = current?.next
                return node!!
            }
        }
    }

    /**
     * Equals function for the list
     * @param other the other list to compare
     * @return whether the lists are equal or not
     * @sample dataStructures.SinglyLinkedListTest.testEquals
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SinglyLinkedList<*>) return false

        if (length != other.length) return false

        var current = head
        var otherCurrent = other.head
        while (current != null) {
            if (current.data != otherCurrent?.data) {
                return false
            }
            current = current.next
            otherCurrent = otherCurrent?.next
        }
        return true
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

    /**
     * Hash code of the list
     * @return the hash code of the list
     */
    override fun hashCode(): Int {
        var result = head?.hashCode() ?: 0
        result = 31 * result + length
        return result
    }
}

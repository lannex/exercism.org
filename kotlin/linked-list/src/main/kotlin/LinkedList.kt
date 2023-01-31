data class Node<T>(
    var value: T,
    var prev: Node<T>? = null,
    var next: Node<T>? = null
)

class Deque<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    // push (insert value at back)
    fun push(value: T) {
        val currentNode = Node(value)

        if (head == null) {
            head = currentNode
            tail = currentNode
        } else {
            tail?.next = currentNode
            currentNode.prev = tail
            tail = currentNode
        }
    }

    // pop (remove value at back)
    fun pop(): T? {
        val node = tail

        return if (node == null) {
            null
        } else {
            tail = node.prev
            tail?.next = null
            node.value
        }
    }

    // shift (remove value at front)
    fun unshift(value: T) {
        val currentNode = Node(value)

        if (head == null) {
            head = currentNode
            tail = currentNode
        } else {
            head?.prev = currentNode
            currentNode.next = head
            head = currentNode
        }
    }

    // unshift (insert value at front)
    fun shift(): T? {
        val node = head

        return if (node == null) {
            null
        } else {
            head = node.next
            head?.prev = null
            node.value
        }
    }
}


package dangsan_231007

class LinkedListGcd {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current = head
        while (current?.next != null) {
            insertGcdAfter(current)
            current = moveToNextNode(current)
        }

        return head
    }

    private fun gcd(max: Int, min: Int): Int {
        return if (min != 0) gcd(min, max % min) else max
    }

    private fun insertGcdAfter(node: ListNode) {
        val nextNode = node.next ?: return
        val gcdValue = gcd(node.`val`, nextNode.`val`)
        val gcdNode = ListNode(gcdValue)

        node.next = gcdNode
        gcdNode.next = nextNode
    }

    private fun moveToNextNode(node: ListNode?): ListNode? {
        return node?.next?.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
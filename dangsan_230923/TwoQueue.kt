package dangsan_230923

import java.util.*

class TwoQueue {}

class Solution1 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val sum = queue1.sum() + queue2.sum()
        if (sum % 2 == 1) return -1

        val q1: Queue<Int> = LinkedList()
        val q2: Queue<Int> = LinkedList()
        queue1.forEach { q1.offer(it) }
        queue2.forEach { q2.offer(it) }

        var count = 0
        val maxCount = (queue1.size + queue2.size) * 2
        while (q1.sum() != q2.sum()) {
            count++

            if (q1.sum() > q2.sum()) {
                q2.offer(q1.poll())
            } else {
                q1.offer(q2.poll())
            }

            if (count > maxCount) return -1
        }

        return count
    }
}

class Solution2 {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val sum = queue1.sum() + queue2.sum()
        if (sum % 2 == 1) return -1

        val q1: Queue<Int> = LinkedList()
        val q2: Queue<Int> = LinkedList()
        queue1.forEach { q1.offer(it) }
        queue2.forEach { q2.offer(it) }

        var count = 0
        val maxCount = (queue1.size + queue2.size) * 2
        while (q1.sum() != q2.sum()) {
            count++

            if (q1.size == 0 || q2.size == 0) return -1

            if (q1.sum() > q2.sum()) {
                q2.offer(q1.poll())
            } else {
                q1.offer(q2.poll())
            }

            if (count > maxCount) return -1
        }

        return count
    }
}
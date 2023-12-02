package dangsan_231202

import kotlin.math.abs

class MovingBalls {
    fun minOperations(boxes: String): IntArray {
        val minOperations = IntArray(boxes.length)
        for (i in boxes.indices) {
            val totalMoves = boxes
                .mapIndexed { i, it -> i to it }
                .filter { it.second == '1' }
                .sumOf { abs(it.first - i) }

            minOperations[i] = totalMoves
        }

        return minOperations
    }
}
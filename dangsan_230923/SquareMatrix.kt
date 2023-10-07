package dangsan_230923

class SquareMatrix {
    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) { 0 } }
        var current = 0 to 0
        var direction = DIRECTION.RIGHT

        for (i in 1..n * n) {
            matrix[current.first][current.second] = i

            val moved = getMoved(current, direction)
            if (isMovedValid(moved, matrix)) {
                current = moved
            } else {
                direction = direction.next()
                current = getMoved(current, direction)
            }
        }

        return matrix
    }

    private fun getMoved(
        current: Pair<Int, Int>,
        direction: DIRECTION
    ): Pair<Int, Int> {
        return when (direction) {
            DIRECTION.RIGHT -> current.first to current.second + 1
            DIRECTION.LEFT -> current.first to current.second - 1
            DIRECTION.DOWN -> current.first + 1 to current.second
            DIRECTION.UP -> current.first - 1 to current.second
        }
    }

    private fun isMovedValid(
        moved: Pair<Int, Int>,
        matrix: Array<IntArray>
    ): Boolean {
        val isNotBelowZero = moved.first >= 0 && moved.second >= 0
        val isNotOutOfBounds = moved.first < matrix.size && moved.second < matrix.size
        val isMovedNotOccupied = isNotBelowZero && isNotOutOfBounds && matrix[moved.first][moved.second] == 0

        return isNotBelowZero && isNotOutOfBounds && isMovedNotOccupied
    }
}

enum class DIRECTION {
    RIGHT,
    LEFT,
    DOWN,
    UP;

    fun next(): DIRECTION {
        return when (this) {
            RIGHT -> DOWN
            LEFT -> UP
            DOWN -> LEFT
            UP -> RIGHT
        }
    }
}
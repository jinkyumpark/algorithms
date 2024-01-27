package dangsan_231202

class HanoiTower {
    fun solution(n: Int): Array<IntArray> {
        hanoi(n, start = 1, end = 3, auxiliary = 2)
        return moves.toTypedArray()
    }

    private fun hanoi(n: Int, start: Int, end: Int, auxiliary: Int) {
        if (n == 0) return

        hanoi(n - 1, start = start, end = auxiliary, auxiliary = end)
        moves.add(intArrayOf(start, end))
        hanoi(n - 1, start = auxiliary, end = end, auxiliary = start)
    }

    companion object {
        private val moves = mutableListOf<IntArray>()
    }
}

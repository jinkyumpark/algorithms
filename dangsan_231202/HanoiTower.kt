package dangsan_231202

class HanoiTower {
    fun solution(n: Int): Array<IntArray> {
        val moves = mutableListOf<IntArray>()
        hanoi(n, 1, 2, 3, moves)
        return moves.toTypedArray()
    }

    private fun hanoi(n: Int, start: Int, auxiliary: Int, end: Int, moves: MutableList<IntArray>) {
        if (n == 0) return

        hanoi(n - 1, start, end, auxiliary, moves)
        moves.add(intArrayOf(start, end))
        hanoi(n - 1, auxiliary, start, end, moves)
    }
}

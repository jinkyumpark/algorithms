package dangsan_231007

class MinMoves {
    fun minMoves(nums: IntArray): Int {
        val min = nums.minOrNull() ?: return 0
        return nums.sumOf { it - min }
    }
}
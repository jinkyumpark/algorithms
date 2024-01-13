package dangsan_240113

/** https://leetcode.com/problems/largest-number/ */
class LargestNumber {
    fun largestNumber(nums: IntArray): String {
        return nums
            .map { it.toString() }
            .sortedWith { x, y -> (y + x).compareTo(x + y) }
            .joinToString("")
            .let {
                when {
                    it.first() == '0' -> "0"
                    else -> it
                }
            }
    }
}

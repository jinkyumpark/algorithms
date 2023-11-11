package dangsan_231111

class MaximumGap {
    // O(n log n)
    fun maximumGap1(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        return nums
            .sorted()
            .zipWithNext { a, b -> b - a }
            .max()
    }

    // Radix Sort : https://en.wikipedia.org/wiki/Radix_sort
    fun maximumGap2(nums: IntArray): Int {
        TODO("implement using Radis Sort")
    }
}

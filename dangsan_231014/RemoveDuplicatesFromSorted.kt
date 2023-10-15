package dangsan_231014

class RemoveDuplicatesFromSorted {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) return nums.size

        var pointer = 2
        for (i in 2 until nums.size) {
            if (nums[i] > nums[pointer - 2]) {
                nums[pointer] = nums[i]
                pointer++
            }
        }

        return pointer
    }
}
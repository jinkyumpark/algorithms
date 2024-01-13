package dangsan_240113

/** https://leetcode.com/problems/combination-sum/submissions/1144732568/ */
class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val validCombinations = mutableListOf<List<Int>>()
        dfs(candidates, target, 0, mutableListOf(), validCombinations)
        return validCombinations
    }

    private fun dfs(
        candidates: IntArray,
        target: Int,
        index: Int,
        current: MutableList<Int>,
        result: MutableList<List<Int>>,
    ) {
        if (target == 0) {
            result.add(ArrayList(current))
            return
        }

        if (target < 0) {
            return
        }

        for (i in index until candidates.size) {
            current.add(candidates[i])
            dfs(candidates, target - candidates[i], i, current, result)
            current.removeAt(current.size - 1)
        }
    }
}

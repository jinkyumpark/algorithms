package dangsan_240113

/** https://school.programmers.co.kr/learn/courses/30/lessons/138476 */
class Tangerine {
    fun solution(k: Int, tangerine: IntArray): Int {
        var remainingTangerine = k

        return tangerine
            .toList()
            .groupingBy { it }
            .eachCount()
            .values
            .sortedDescending()
            .takeWhile { tangerineCountOfSameType ->
                remainingTangerine >
                    tangerineCountOfSameType
                        .also { remainingTangerine -= tangerineCountOfSameType }
            }
            .count()
            .let { it + 1 }
    }
}

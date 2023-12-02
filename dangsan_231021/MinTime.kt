package dangsan_231021

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import kotlin.math.abs
import kotlin.math.min

class MinTime {
    fun findMinDifference(timePoints: List<String>): Int {
        val timeConverted = timePoints
            .map {
                LocalDateTime.of(
                    0,
                    1,
                    1,
                    it.parse().first, it.parse().second
                )
            }
            .sorted()

        println(timeConverted)

        val timeDifferences = mutableListOf<Int>()
        timeConverted.zipWithNext { current, next ->
            timeDifferences.add(
                min(
                    current.differences(next.minusDays(1)),
                    current.minusDays(1).differences(next),
                    current.differences(next.plusDays(1)),
                    current.plusDays(1).differences(next),
                )
            )
        }

        return abs(timeDifferences.min())
    }

    private fun min(int1: Int, int2: Int, int3: Int, int4: Int, int5: Int): Int {
        return min(
            min(int1, int2),
            min(
                int3, min(
                    int4,
                    int5
                )
            )

        )
    }

    private fun LocalDateTime.differences(of: LocalDateTime): Int {
        return ChronoUnit
            .MINUTES
            .between(this, of)
            .toInt()
    }

    private fun String.parse(): Pair<Int, Int> {
        val split = this.split(":")
        return split.first().toInt() to split.last().toInt()
    }
}
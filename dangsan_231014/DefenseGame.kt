package dangsan_231014

import java.util.PriorityQueue

class DefenseGame {
    fun solution(totalSoldiers: Int, maxPasses: Int, enemies: IntArray): Int {
        if (maxPasses >= enemies.size) return enemies.size

        val strongestEnemies = PriorityQueue<Int>()
        var remainingSoldiers = totalSoldiers
        var availablePasses = maxPasses
        var completedRounds = 0

        for (currentEnemy in enemies) {
            remainingSoldiers -= currentEnemy
            strongestEnemies += -currentEnemy

            if (remainingSoldiers < 0 && availablePasses > 0) {
                remainingSoldiers += -strongestEnemies.poll()
                availablePasses--
            }

            if (remainingSoldiers < 0) break
            completedRounds++
        }

        return completedRounds
    }
}
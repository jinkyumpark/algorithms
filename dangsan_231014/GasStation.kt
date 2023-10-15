package dangsan_231014

class GasStation {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var totalGas = 0
        var currentGas = 0
        var startIndex = 0

        for (i in gas.indices) {
            totalGas += gas[i] - cost[i]
            currentGas += gas[i] - cost[i]

            if (currentGas < 0) {
                currentGas = 0
                startIndex = i + 1
            }
        }

        return if (totalGas < 0) -1 else startIndex
    }
}
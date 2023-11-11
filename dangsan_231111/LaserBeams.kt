package dangsan_231111

class LaserBeams {
    fun numberOfBeams(bank: Array<String>): Int {
        var previousDeviceCount = 0
        var totalBeams = 0

        for (bankRow in bank) {
            val currentDeviceCount = bankRow.count { it == '1' }

            if (currentDeviceCount > 0 && previousDeviceCount > 0) {
                totalBeams += previousDeviceCount * currentDeviceCount
            }

            if (currentDeviceCount > 0) {
                previousDeviceCount = currentDeviceCount
            }
        }

        return totalBeams
    }
}

package dangsan_240127

class CustomSortString {
    fun customSortString(order: String, s: String): String {
        val countMap = s
            .groupingBy { it.toString() }
            .eachCount()

        val orderAppearingInS = order
            .split("")
            .filter { it in s }
            .joinToString("") { it.repeat(countMap[it] ?: 0) }

        val sNotAppearingInOrder = s
            .split("")
            .filterNot { it in order }
            .joinToString("")

        return orderAppearingInS + sNotAppearingInOrder
    }
}

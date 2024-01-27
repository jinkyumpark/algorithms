package dangsan_240127

class SortVowelsInAString {
    fun sortVowels(s: String): String {
        val vowels = s
            .filter { it.toString().lowercase() in VOWEL }
            .toList()
            .sorted()

        var vowelIndex = 0
        return s
            .map { char ->
                when (char.toString().lowercase() in VOWEL) {
                    true -> vowels[vowelIndex++]
                    false -> char
                }
            }
            .joinToString("")
    }

    companion object {
        private val VOWEL = arrayOf("a", "i", "e", "o", "u")
    }
}

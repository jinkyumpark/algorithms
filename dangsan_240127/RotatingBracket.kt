package dangsan_240127

class RotatingBracket {
    fun solution(s: String): Int {
        return s
            .indices
            .map { s.rotate(it) }
            .count { isValid(it) }
    }

    private fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in s) {
            when (char) {
                '(', '[', '{' -> stack.addLast(char)
                ')', ']', '}' -> {
                    val isValid = stack.isNotEmpty()
                            && isMatchingPair(stack.removeLast(), char)

                    if (!isValid) {
                        return false
                    }
                }
            }
        }

        return stack.isEmpty()
    }

    private fun isMatchingPair(open: Char, close: Char): Boolean {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}')
    }

    private fun String.rotate(n: Int): String {
        val rotationPoint = (n % length + length) % length
        return drop(rotationPoint) + take(rotationPoint)
    }
}

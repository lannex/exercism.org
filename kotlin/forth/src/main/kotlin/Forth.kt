class Forth {
    private val deque = ArrayDeque<Int>()

    private val userDefinedWords = mutableMapOf<String, String>();

    fun evaluate(vararg line: String): List<Int> {
        deque.clear()
        userDefinedWords.clear()

        line.forEach {
            val lowercaseLine = it.lowercase()
            if (lowercaseLine.startsWith(":")) {
                evaluateUserDefinedWords(lowercaseLine)
            } else {
                lowercaseLine
                    .split(" ")
                    .forEach { x -> evaluateWord(x) }
            }
        }

        return deque.toList()
    }

    private fun evaluateUserDefinedWords(line: String) {
        line
            .replace(": ", "")
            .replace(" ;", "")
            .split(" ")
            .let { xs ->
                if (xs.first().all(Char::isDigit)) {
                    throw Exception("illegal operation")
                }

                userDefinedWords[xs[0]] = xs
                    .drop(1)
                    .map {
                        if (it in userDefinedWords) {
                            userDefinedWords[it]
                        } else {
                            it
                        }
                    }
                    .joinToString(" ")
            }
    }

    private fun evaluateWord(word: String) {
        when {
            word in userDefinedWords -> {
                userDefinedWords[word]
                    ?.split(" ")
                    ?.forEach { evaluateWord(it) }
            }

            word == "+" -> add()
            word == "-" -> subtract()
            word == "*" -> multiply()
            word == "/" -> divide()
            word == "dup" -> duplicate()
            word == "drop" -> drop()
            word == "swap" -> swap()
            word == "over" -> over()
            word.all(Char::isDigit) -> deque.addLast(word.toInt())
            else -> throw Exception("undefined operation")
        }
    }

    private fun add() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        val first = deque.removeLast()
        deque.addLast(first + second)
    }

    private fun subtract() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        val first = deque.removeLast()
        deque.addLast(first - second)
    }

    private fun multiply() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        val first = deque.removeLast()
        deque.addLast(first * second)
    }

    private fun divide() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        if (second == 0) {
            throw Exception("divide by zero")
        }
        val first = deque.removeLast()
        deque.addLast(first / second)
    }

    private fun duplicate() {
        throwIfEmpty()
        val value = deque.last()
        deque.addLast(value)
    }

    private fun drop() {
        throwIfEmpty()
        deque.removeLast()
    }

    private fun swap() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        val first = deque.removeLast()
        deque.addLast(second)
        deque.addLast(first)
    }

    private fun over() {
        throwIfEmpty()
        throwIfSize1()
        val second = deque.removeLast()
        val first = deque.last()
        deque.addLast(second)
        deque.addLast(first)
    }

    private fun throwIfEmpty() {
        if (deque.isEmpty()) {
            throw Exception("empty stack")
        }
    }

    private fun throwIfSize1() {
        if (deque.size == 1) {
            throw Exception("only one value on the stack")
        }
    }
}

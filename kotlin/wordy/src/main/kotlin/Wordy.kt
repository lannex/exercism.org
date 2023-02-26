import kotlin.math.pow

object Wordy {
    private enum class Operation(val op: String) {
        PLUS("plus"),
        MINUS("minus"),
        MULTIPLY("multiple"),
        DIVIDE("divide"),
        POW("pow")
    }

    fun answer(input: String): Int {
        val requiredList = input.split(" ").take(2)
        require(requiredList.first() == "What" && requiredList.last() == "is")

        return getAnswer(
            input
                .removePrefix("What is ")
                .removeSuffix("?")
                .replace("multiplied by", Operation.MULTIPLY.op)
                .replace("divided by", Operation.DIVIDE.op)
                .replace("raised to the", Operation.POW.op)
                .replace("th power", "")
                .split(" ")
        )
    }

    private tailrec fun getAnswer(list: List<String>): Int {
        if (list.size == 1) {
            return list.first().toInt()
        }

        val result = calculateWithOp(
            first = list.first().toInt(),
            op = list[1],
            second = list[2].toInt()
        )

        return getAnswer(listOf(result.toString()) + list.drop(3))
    }

    private fun calculateWithOp(first: Int, op: String, second: Int): Int =
        when (op) {
            Operation.PLUS.op -> first + second
            Operation.MINUS.op -> first - second
            Operation.MULTIPLY.op -> first * second
            Operation.DIVIDE.op -> first / second
            Operation.POW.op -> first.toDouble().pow(second.toDouble()).toInt()
            else -> throw IllegalArgumentException()
        }
}

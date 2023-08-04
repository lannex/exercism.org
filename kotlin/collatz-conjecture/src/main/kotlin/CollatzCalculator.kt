object CollatzCalculator {
    fun computeStepCount(start: Int): Int {
        require(start > 0)

        return generateSequence(start) { n ->
            when {
                n.isFinished -> null
                n.isEven -> n / 2
                else -> 3 * n + 1
            }
        }.count() - 1
    }

    private val Int.isFinished: Boolean
        get() = this == 1

    private val Int.isEven: Boolean
        get() = this % 2 == 0
}

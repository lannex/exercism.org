data class Year(private val year: Int) {
    val isLeap: Boolean =
        isDivisibleBy(4) &&
                (!isDivisibleBy(100) || isDivisibleBy(400))

    private fun isDivisibleBy(divisor: Int) = year % divisor == 0
}

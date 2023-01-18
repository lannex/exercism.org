import kotlin.math.pow

class Squares(number: Int) {
    private val rangeNumber = 1..number

    fun sumOfSquares(): Int = rangeNumber
        .sumOf { it.squared() }

    fun squareOfSum(): Int = rangeNumber
        .sum()
        .squared()

    fun difference(): Int = squareOfSum() - sumOfSquares()

    private fun Int.squared(): Int = toDouble().pow(2).toInt()
}

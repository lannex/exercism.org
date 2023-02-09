import kotlin.math.pow

object ArmstrongNumber {
    fun check(input: Int): Boolean {
        val list = input
            .toString()
            .map { it.digitToInt() }

        return list
            .map { it.toFloat().pow(list.size) }
            .sumOf(Float::toInt)
            .equals(input)
    }
}

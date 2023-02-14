object RomanNumerals {
    private val numToRoman = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    fun value(n: Int): String {
        if (n <= 0) return ""

        val key = numToRoman.keys.findLast { it <= n }
            ?: throw IllegalArgumentException("Invalid number: $n")

        return numToRoman[key] + value(n - key)
    }
}

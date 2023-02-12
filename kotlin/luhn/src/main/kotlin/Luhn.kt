object Luhn {
    fun isValid(candidate: String): Boolean {
        if (candidate.length <= 1 ||
            candidate.startsWith(" ") ||
            candidate.any { !(it in '0'..'9' || it == ' ') }
        ) return false

        return candidate
            .reversed()
            .filter(Char::isDigit)
            .mapIndexed(::calcDoubling)
            .sum() % 10 == 0
    }

    private fun calcDoubling(i: Int, c: Char): Int {
        val num = c.digitToInt()
        return num.takeUnless { (i + 1) % 2 == 0 }
            ?: (num * 2).calcIfGreater()
    }

    private fun Int.calcIfGreater() = if (this > 9) this - 9 else this
}

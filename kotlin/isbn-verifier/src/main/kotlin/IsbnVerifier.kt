class IsbnVerifier {
    companion object {
        private const val ISBN_LENGTH: Int = 10
    }

    fun isValid(number: String): Boolean =
        number
            .replace("-", "")
            .apply { if (length != ISBN_LENGTH) return false }
            .mapIndexed { i, c ->
                when {
                    c in '0'..'9' -> c.digitToInt()
                    i == ISBN_LENGTH - 1 && c == 'X' -> 10
                    else -> return false
                } * (10 - i)
            }
            .sum() % 11 == 0
}

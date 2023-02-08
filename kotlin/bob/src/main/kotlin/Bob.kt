object Bob {
    fun hey(input: String): String {
        return input.trim().run {
            val hasQuestion = endsWith('?')

            val filteredLetter = filter(Char::isLetter)
            val isYell = filteredLetter.isNotEmpty() && filteredLetter.hasUpperCase()

            when {
                hasQuestion && isYell -> "Calm down, I know what I'm doing!"
                hasQuestion -> "Sure."
                isYell -> "Whoa, chill out!"
                isEmpty() -> "Fine. Be that way!"
                else -> "Whatever."
            }
        }
    }

    private fun String.hasUpperCase(): Boolean = all(Char::isUpperCase)
}

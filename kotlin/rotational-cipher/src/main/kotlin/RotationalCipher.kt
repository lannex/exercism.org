class RotationalCipher(private val rot: Int) {
    private val alphabet = ('a'..'z').toList()

    fun encode(text: String): String =
        text.map { c ->
            when (val lower = c.lowercaseChar()) {
                in alphabet -> {
                    val index = (alphabet.indexOf(lower) + rot) % 26
                    val result = alphabet[index]

                    if (c.isUpperCase()) result.uppercaseChar() else result
                }

                else -> c
            }
        }.joinToString("")
}

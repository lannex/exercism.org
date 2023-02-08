object Acronym {
    fun generate(phrase: String): String =
        phrase
            .split(" ", ", ", "-", "_")
            .filter(String::isNotEmpty)
            .joinToString("") { it.first().uppercase() }
}

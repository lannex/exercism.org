object Isogram {

    fun isIsogram(input: String): Boolean = input
        .lowercase()
        .split("")
        .filter { it.isNotEmpty() && it != " " && it != "-" }
        .let { it.size <= it.toSet().size }
}

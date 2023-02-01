object Raindrops {
    private val raindrops = mapOf(
        3 to "Pling",
        5 to "Plang",
        7 to "Plong"
    )

    // buildString { ... append(...) ... }
    // raindrops.filterKeys { n % it == 0 }.values.joinToString("")
    fun convert(n: Int): String = raindrops
        .map { (key, value) ->
            if (n % key == 0) value
            else ""
        }
        .joinToString("")
        .ifEmpty { n.toString() }
}



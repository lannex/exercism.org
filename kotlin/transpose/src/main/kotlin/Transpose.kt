object Transpose {
    fun transpose(input: List<String>): List<String> {
        val cols = input.maxOfOrNull { it.length } ?: 0

        return (0 until cols).map { col ->
            input
                .map { it.getOrNull(col) } // rows
                .dropLastWhile { it == null }
                .joinToString("") {
                    it?.toString() ?: " "
                }
        }
    }
}

class DiamondPrinter {
    fun printToList(str: Char): List<String> {
        val row = ('A' until str) + (str downTo 'A')
        val col = (str downTo 'A') + ('B'..str)

        return row.map { r ->
            col.map { c ->
                if (r == c) c else ' '
            }.joinToString("")
        }
    }
}

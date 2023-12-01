object PascalsTriangle {

    fun computeTriangle(rows: Int): List<List<Int>> =
        if (rows == 0) emptyList() else generateTriangle(rows)


    private fun generateTriangle(rows: Int): List<List<Int>> {
        if (rows == 1) {
            return listOf(listOf(1))
        }
        val previousTriangle = generateTriangle(rows - 1)
        val lastRow = previousTriangle.last()
        val nextRow = listOf(1) + lastRow.zipWithNext { a, b -> a + b } + listOf(1)
        return previousTriangle + listOf(nextRow)
    }
}

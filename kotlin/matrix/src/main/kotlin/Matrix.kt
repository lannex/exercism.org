class Matrix(private val matrixAsString: String) {
    private val matrix = matrixAsString
        .split("\n")
        .map {
            it.split(" ").map { str ->
                str.toInt()
            }
        }

    fun column(colNr: Int): List<Int> = matrix.map { it[colNr - 1] }

    fun row(rowNr: Int): List<Int> = matrix[rowNr - 1]
}

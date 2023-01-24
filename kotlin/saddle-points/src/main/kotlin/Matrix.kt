data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {
    private val colMinItems = (0 until matrix[0].size).map { col ->
        matrix.minOfOrNull { it[col] }
    }

    val saddlePoints: Set<MatrixCoordinate> =
        matrix.mapIndexed { n, row ->
            val rowMax = row.maxOrNull()

            row.mapIndexed { m, it ->
                if (it == rowMax && it == colMinItems[m]) {
                    MatrixCoordinate(n + 1, m + 1)
                } else {
                    null
                }
            }
        }
            .flatten()
            .filterNotNull()
            .toSet()
}

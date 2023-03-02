data class MinesweeperBoard(val inputBoard: List<String>) {
    // ↖ ↑ ↗
    // ← • →
    // ↙ ↓ ↘
    private val adjacentMines = listOf(
        -1 to -1, -1 to 0, -1 to 1,
        0 to -1, 0 to 1,
        1 to -1, 1 to 0, 1 to 1
    )

    fun withNumbers(): List<String> =
        inputBoard.mapIndexed { rowIndex, row ->
            row
                .mapIndexed { colIndex, col ->
                    if (col == ' ') {
                        countAdjacentMines(rowIndex, colIndex).run {
                            ' '.takeIf { this == 0 } ?: this
                        }
                    } else col
                }
                .joinToString("")
        }

    private fun countAdjacentMines(rowIndex: Int, colIndex: Int): Int =
        adjacentMines
            .mapNotNull { (rowOffset, colOffset) ->
                inputBoard
                    .getOrNull(rowIndex + rowOffset)
                    ?.getOrNull(colIndex + colOffset)
            }
            .count { it == '*' }
}


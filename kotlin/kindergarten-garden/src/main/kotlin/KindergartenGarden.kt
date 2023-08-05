class KindergartenGarden(private val diagram: String) {
    private val students = listOf(
        "Alice", "Bob", "Charlie", "David",
        "Eve", "Fred", "Ginny", "Harriet",
        "Ileana", "Joseph", "Kincaid", "Larry"
    )

    private val plants = mapOf(
        'V' to "violets",
        'R' to "radishes",
        'C' to "clover",
        'G' to "grass"
    )

    private val convertedDiagram =
        diagram
            .lines()
            .map { it.chunked(2) }
            .reduce { acc, curr ->
                acc.zip(curr) { firstRow, secondRow -> firstRow + secondRow }
            }

    fun getPlantsOfStudent(student: String): List<String> {
        return students
            .indexOf(student)
            .let { i ->
                convertedDiagram[i].map {
                    plants.getOrElse(it) {
                        throw IllegalArgumentException()
                    }
                }
            }
    }
}

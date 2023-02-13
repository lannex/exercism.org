class Dna(private val input: String) {
    init {
        require(input.all { it in "ACGT" })
    }

    val nucleotideCounts: Map<Char, Int>
        get() {
//            val toMap = input
//                .groupBy { it }
//                .map { it.key to it.value.size }
//                .toMap()

            val toMap = input.groupingBy { it }.eachCount()
            return mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + toMap
        }
}

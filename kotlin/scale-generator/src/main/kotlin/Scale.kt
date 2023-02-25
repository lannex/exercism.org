class Scale(private val tonic: String) {
    private val sharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val flats = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")

    fun chromatic(): List<String> {
        val capitalizedTonic = tonic.first().uppercase() + tonic.drop(1)
        val selectedList = if (capitalizedTonic.endsWith("#")) sharps else flats
        val tonicIndex = selectedList.indexOf(capitalizedTonic)
        return selectedList.drop(tonicIndex) + selectedList.take(tonicIndex)
    }

    fun interval(intervals: String): List<String> {
        val indexes =
            intervals
                .map {
                    when (it) {
                        'A' -> 3
                        'M' -> 2
                        else -> 1
                    }
                }
                .reversed()
                .windowed(intervals.length, 1, true)
                .map { it.sum() }

        val chromatic = chromatic()

        return listOf(chromatic.first()) +
                chromatic.filterIndexed { index, _ -> index in indexes }
    }
}

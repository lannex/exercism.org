class Robot2 {
    companion object {
        private val nameSequences = generateSequence { generateName() }
            .distinct()
            .iterator()

        private fun generateName(): String {
            val str = Array(2) { ('A'..'Z').random() }.joinToString("")
            val num = Array(3) { (0..9).random() }.joinToString("")
            return "$str$num"
        }
    }

    var name: String = nameSequences.next()

    fun reset() {
        name = nameSequences.next()
    }
}

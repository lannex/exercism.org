class Robot {
    companion object {
        private val names = mutableSetOf<String>()
    }

    var name: String = ""
        get() {
            field = when (field == "") {
                true -> generateName()
                false -> field
            }
            return field
        }

    private fun generateName(): String {
        val str = Array(2) { ('A'..'Z').random() }.joinToString("")
        val num = Array(3) { (0..9).random() }.joinToString("")
        val result = "$str$num"

        return when (!names.add(result)) {
            true -> generateName()
            false -> result
        }
    }

    fun reset() {
        name = generateName()
    }
}

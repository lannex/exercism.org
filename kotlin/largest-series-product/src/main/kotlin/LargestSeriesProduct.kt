class Series(private val input: String) {

    init {
        require(input.all(Char::isDigit))
    }

    fun getLargestProduct(span: Int): Long? {
        require(input.length >= span)
        require(span >= 0)

        if (span == 0) return 1

        return (0..input.length - span).maxOfOrNull {
            input
                .substring(it, it + span)
                .map { c -> c.digitToInt().toLong() }
                .reduce(Long::times)
        }
    }
}

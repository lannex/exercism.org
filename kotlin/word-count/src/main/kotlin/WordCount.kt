object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase
            .lowercase()
            .split(' ', ',')
            .map {
                it.trim { c -> !c.isLetterOrDigit() }
            }
            .filter(String::isNotEmpty)
            .groupBy { it }
            .mapValues { it.value.size }
//            .groupingBy { it }
//            .eachCount()
    }
}

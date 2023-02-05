class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val sourceLowerCase = source.lowercase()

        return anagrams
            .filter { word ->
                val wordLowerCase = word.lowercase()

                word.length == source.length
                        && wordLowerCase != sourceLowerCase
                        && wordLowerCase.groupBy { it } == sourceLowerCase.groupBy { it }
            }
            .toSet()
    }
}

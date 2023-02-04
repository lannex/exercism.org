object PigLatin {
    private val vowels = arrayOf('a', 'e', 'i', 'o', 'u')
    private val vowels2 = arrayOf("yt", "xr")
    private val consonants = ('a'..'z').filter { it !in vowels }
    private val consonants2 = arrayOf("ch", "qu", "th", "rh")
    private val consonants3 = arrayOf("thr", "sch")

    private const val newSound = "ay"

    fun translate(phrase: String): String = phrase
        .split(" ")
        .joinToString(" ", transform = PigLatin::translateWord)

    private fun translateWord(word: String): String = when {
        word.first() in vowels || word.take(2) in vowels2 -> word + newSound
        word.drop(1).take(2) == "qu" -> word.drop(3) + word.take(3) + newSound
        word.take(3) in consonants3 -> word.drop(3) + word.take(3) + newSound
        word.take(2) in consonants2 -> word.drop(2) + word.take(2) + newSound
        word.first() in consonants -> word.drop(1) + word.first() + newSound
        else -> word
    }
}

import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {
    fun ciphertext(plaintext: String): String {
        val filteredText = plaintext
            .lowercase()
            .filter { it.isLetterOrDigit() }
            .ifEmpty { return "" }

        val cols = ceil(sqrt(filteredText.length.toDouble())).toInt()
        val filteredTextList = filteredText.chunked(cols)

        return (0 until cols)
            .joinToString(" ") { col ->
                filteredTextList
                    .map { it.getOrElse(col) { ' ' } }
                    .joinToString("")
            }
    }
}

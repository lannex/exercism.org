object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        require(startBottles in 0..99)

        return (startBottles downTo takeDown).joinToString("\n") { cnt ->
            val current = setBottleText(cnt)
            val next = setBottleText(cnt - 1)
            val take = setTakeText(cnt)

            "${current.uppercaseFirstChar()} of beer on the wall, $current of beer.\n$take, $next of beer on the wall.\n"
        }
    }

    private fun setTakeText(cnt: Int): String =
        when (cnt) {
            0 -> "Go to the store and buy some more"
            1 -> "Take it down and pass it around"
            else -> "Take one down and pass it around"
        }

    private fun setBottleText(cnt: Int): String =
        when (cnt) {
            -1 -> "99 bottles"
            0 -> "no more bottles"
            1 -> "1 bottle"
            else -> "$cnt bottles"
        }

    private fun String.uppercaseFirstChar(): String = replaceFirstChar { it.uppercase() }
}

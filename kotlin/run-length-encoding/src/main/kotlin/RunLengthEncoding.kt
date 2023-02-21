object RunLengthEncoding {
    fun encode(input: String): String =
        input.replace("(.)\\1+".toRegex()) {
            "${it.value.length}${it.value.first()}"
        }

    fun decode(input: String): String =
        input.replace("(\\d+)(.)".toRegex()) {
            val (num, c) = it.destructured
            c.repeat(num.toInt())
        }
}

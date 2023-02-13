class PhoneNumber(private val input: String) {
    val number: String = input
        .removePrefix("1")
        .removePrefix("+1")
        .filter(Char::isDigit)

    init {
        require(number.length == 10)
        require(number.first().digitToInt() >= 2)
        require(number[3].digitToInt() >= 2)
    }
}

object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        val result =
            Signal
                .values()
                .toList()
                .filterIndexed { index, _ ->
                    number and (1 shl index) != 0
                }
        return when {
            number and 16 != 0 -> result.reversed() // 0b10000
            else -> result
        }
    }
}

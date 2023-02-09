object ResistorColorTrio {

    fun text(vararg input: Color): String {
        require(input.size == 3)

        val value = (input.take(2).map { it.ordinal }.joinToString("")
                + "0".repeat(input.last().ordinal))
            .toLong()

        return when {
            value < Unit.KILOOHMS.value -> "$value ohms"
            value < Unit.MEGAOHMS.value -> "${value / Unit.KILOOHMS.value} kiloohms"
            value < Unit.GIGAOHMS.value -> "${value / Unit.MEGAOHMS.value} megaohms"
            value < Unit.TERAOHMS.value -> "${value / Unit.GIGAOHMS.value} gigaohms"
            value < Unit.PETAOHMS.value -> "${value / Unit.TERAOHMS.value} teraohms"
            value < Unit.EXAOHMS.value -> "${value / Unit.PETAOHMS.value} petaohms"
            else -> "${value / Unit.EXAOHMS.value} exaohms"
        }
    }
}

object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors
            .take(2)
            .joinToString("") {
//                Color.values().indexOf(it).toString()
//                it.ordinal.toString()
                it.value.toString()
            }
            .toInt()
    }
}

object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        require(n <= s.length)
        require(n > 0)
        require(s.isNotEmpty())

        return s.map { it.digitToInt() }.windowed(n)
    }
}

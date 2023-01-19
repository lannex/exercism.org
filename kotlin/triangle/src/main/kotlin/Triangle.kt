class Triangle<out T : Number>(a: T, b: T, c: T) {
    init {
        val aDouble = a.toDouble()
        val bDouble = b.toDouble()
        val cDouble = c.toDouble()

        require(aDouble > 0 || bDouble > 0 || cDouble > 0)
        require(bDouble + cDouble > aDouble)
        require(aDouble + cDouble > bDouble)
        require(aDouble + bDouble > cDouble)
    }

    val isEquilateral: Boolean = a == b && b == c

    val isIsosceles: Boolean = a == b || b == c || a == c

    val isScalene: Boolean = a != b && b != c && a != c
}


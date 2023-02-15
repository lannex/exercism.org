class CustomSet(vararg values: Int) {
    private var elements: IntArray = values.distinct().toIntArray()

    fun isEmpty(): Boolean = elements.isEmpty()

    fun isSubset(other: CustomSet): Boolean = elements.all { other.contains(it) }

    fun isDisjoint(other: CustomSet): Boolean = elements.none { other.contains(it) }

//    fun contains(other: Int): Boolean =
//        elements.find { it == other } != null

    fun contains(other: Int): Boolean = elements.contains(other)

    fun intersection(other: CustomSet): CustomSet =
        CustomSet(
            *other.elements
                .filter { elements.contains(it) }
                .toIntArray()
        )

    fun add(other: Int) {
        if (!contains(other)) elements += other
    }

    override fun equals(other: Any?): Boolean {
        if (other !is CustomSet) return false
        return elements
            .sorted()
            .toIntArray()
            .contentEquals(other.elements.sorted().toIntArray())
    }

    operator fun plus(other: CustomSet): CustomSet =
        CustomSet(*elements, *other.elements)

    operator fun minus(other: CustomSet): CustomSet =
        CustomSet(
            *elements.filter { !other.contains(it) }.toIntArray()
        )
}

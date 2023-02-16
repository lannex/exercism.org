class Allergies(score: Int) {
    private var list: List<Allergen>

    init {
        var s = score
        list = Allergen
            .values()
            .sortedByDescending { it.score }
            .mapNotNull { allergen ->
                allergen
                    .takeIf { s / allergen.score > 0 }
                    .also { s %= allergen.score }
            }
            .reversed()
    }

    fun getList(): List<Allergen> = list

    fun isAllergicTo(allergen: Allergen): Boolean =
        list.contains(allergen)
}

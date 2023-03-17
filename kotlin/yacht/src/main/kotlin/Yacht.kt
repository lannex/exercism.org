object Yacht {
    fun solve(category: YachtCategory, vararg dicesArgs: Int): Int {
        val dices = dicesArgs.toList()

        return when (category) {
            YachtCategory.YACHT ->
                50.takeIf { dices.toSet().size == 1 } ?: 0

            YachtCategory.ONES ->
                dices.countValues().getOrDefault(1, 0) * 1

            YachtCategory.TWOS ->
                dices.countValues().getOrDefault(2, 0) * 2

            YachtCategory.THREES ->
                dices.countValues().getOrDefault(3, 0) * 3

            YachtCategory.FOURS ->
                dices.countValues().getOrDefault(4, 0) * 4

            YachtCategory.FIVES ->
                dices.countValues().getOrDefault(5, 0) * 5

            YachtCategory.SIXES ->
                dices.countValues().getOrDefault(6, 0) * 6

            YachtCategory.FULL_HOUSE ->
                if (dices.toSet().size == 2 && dices.countValues().containsSameValue(3))
                    dices.sum()
                else 0

            YachtCategory.FOUR_OF_A_KIND ->
                if (dices.toSet().size == 1 || dices.countValues().containsSameValue(4))
                    dices
                        .countValues()
                        .filter { it.value >= 4 }
                        .keys
                        .sum() * 4
                else 0

            YachtCategory.LITTLE_STRAIGHT ->
                if (dices.toSet().size == 5 && dices.containsAll(listOf(1, 2, 3, 4, 5)))
                    30
                else 0

            YachtCategory.BIG_STRAIGHT ->
                if (dices.toSet().size == 5 && dices.containsAll(listOf(2, 3, 4, 5, 6)))
                    30
                else 0

            YachtCategory.CHOICE -> dices.sum()
        }
    }

    private fun List<Int>.countValues(): Map<Int, Int> =
        this.groupingBy { it }.eachCount()

    private fun Map<Int, Int>.containsSameValue(cnt: Int): Boolean =
        this.values.contains(cnt)
}

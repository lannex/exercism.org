data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    val matrix = Array(items.size + 1) { IntArray(maximumWeight + 1) }

    (1..items.size).forEach { m ->
        // Current item
        val (weight, value) = items[m - 1]

        (1..maximumWeight).forEach { n ->
            val prevValue = matrix[m - 1][n]

            matrix[m][n] = if (weight > n) {
                // If you can't add the current item, use a value from a previous item
                prevValue
            } else {
                // Select the maximum value for adding the current item versus not adding it
                maxOf(prevValue, matrix[m - 1][n - weight] + value)
            }
        }
    }

    return matrix[items.size][maximumWeight]
}

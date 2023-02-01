object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        if (list.isEmpty()) {
            throw NoSuchElementException()
        }

        val midIndex = list.size / 2
        val mid = list[midIndex]

        return when {
            mid > item -> {
                val left = list.subList(0, midIndex)
                search(left, item)
            }

            mid < item -> {
                val right = list.subList(midIndex + 1, list.size)
                (midIndex + 1) + search(right, item)
            }

            else -> midIndex
        }
    }
}

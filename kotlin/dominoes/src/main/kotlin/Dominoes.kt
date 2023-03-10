class ChainNotFoundException(msg: String) : RuntimeException(msg)

data class Domino(val left: Int, val right: Int) {
    fun reverse() = Domino(right, left)
}

data class DominoesGroup(val usedList: List<Domino>, val unusedList: List<Domino>)

object Dominoes {
    fun formChain(vararg inputDominoes: Domino): List<Domino> = formChain(inputDominoes.toList())

    fun formChain(inputDominoes: List<Domino>): List<Domino> {
        if (inputDominoes.isEmpty()) return emptyList()
        return validateDominoes(inputDominoes)
    }

    private fun validateDominoes(dominoes: List<Domino>): List<Domino> {
        val deque = ArrayDeque<DominoesGroup>()
        deque.addLast(
            DominoesGroup(dominoes.take(1), dominoes.drop(1))
        )

        while (deque.size > 0) {
            val (currentList, rest) = deque.removeLast()
            val currentFirstLeft = currentList.first().left
            val currentLastRight = currentList.last().right

            if (rest.isEmpty() && currentFirstLeft == currentLastRight) {
                return currentList
            }

            rest
                .filter {
                    it.left == currentLastRight || it.right == currentLastRight
                }
                .forEach { originDomino ->
                    val domino = originDomino.takeIf { currentLastRight == it.left }
                        ?: originDomino.reverse()
                    deque.addLast(
                        DominoesGroup(currentList + domino, rest - originDomino)
                    )
                }
        }

        throw ChainNotFoundException("No chain found for $dominoes")
    }
}

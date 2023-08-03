import Orientation.*

class Robot(
    var gridPosition: GridPosition = GridPosition(0, 0),
    var orientation: Orientation = NORTH
) {
    private fun turnRight() {
        orientation = when (orientation) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }
    }

    private fun turnLeft() {
        orientation = when (orientation) {
            NORTH -> WEST
            WEST -> SOUTH
            SOUTH -> EAST
            EAST -> NORTH
        }
    }

    private fun advance() {
        val (x, y) = gridPosition
        gridPosition = when (orientation) {
            NORTH -> GridPosition(x, y + 1)
            EAST -> GridPosition(x + 1, y)
            SOUTH -> GridPosition(x, y - 1)
            WEST -> GridPosition(x - 1, y)
        }
    }

    fun simulate(instructions: String) {
        instructions.forEach {
            when (it) {
                'R' -> turnRight()
                'L' -> turnLeft()
                'A' -> advance()
                else -> throw IllegalArgumentException("Invalid instruction: $it")
            }
        }
    }
}

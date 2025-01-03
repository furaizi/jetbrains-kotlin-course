package module_5.assignment.games.game2048.src.game2048

import module_5.assignment.board.src.board.Cell
import module_5.assignment.board.src.board.Direction
import module_5.assignment.board.src.board.GameBoard
import module_5.assignment.board.src.board.createGameBoard
import module_5.assignment.games.game.src.game.Game

/*
 * Your task is to implement the game 2048 https://en.wikipedia.org/wiki/2048_(video_game).
 * Implement the utility methods below.
 *
 * After implementing it you can try to play the game running 'PlayGame2048'.
 */
fun newGame2048(initializer: Game2048Initializer<Int> = RandomGame2048Initializer): Game =
        Game2048(initializer)

class Game2048(private val initializer: Game2048Initializer<Int>) : Game {
    private val board = createGameBoard<Int?>(4)

    override fun initialize() {
        repeat(2) {
            board.addNewValue(initializer)
        }
    }

    override fun canMove() = board.any { it == null }

    override fun hasWon() = board.any { it == 2048 }

    override fun processMove(direction: Direction) {
        if (board.moveValues(direction)) {
            board.addNewValue(initializer)
        }
    }

    override fun get(i: Int, j: Int): Int? = board.run { get(getCell(i, j)) }
}

/*
 * Add a new value produced by 'initializer' to a specified cell in a board.
 */
fun GameBoard<Int?>.addNewValue(initializer: Game2048Initializer<Int>) {
    val (cell, value) = initializer.nextValue(this) ?: (null to null)
    this[cell] = value
}

/*
 * Update the values stored in a board,
 * so that the values were "moved" in a specified rowOrColumn only.
 * Use the helper function 'moveAndMergeEqual' (in Game2048Helper.kt).
 * The values should be moved to the beginning of the row (or column),
 * in the same manner as in the function 'moveAndMergeEqual'.
 * Return 'true' if the values were moved and 'false' otherwise.
 */
fun GameBoard<Int?>.moveValuesInRowOrColumn(rowOrColumn: List<Cell>): Boolean {
    val originalValues = rowOrColumn.map { this[it] }
    val newValues = originalValues.moveAndMergeEqual { it * 2 }

    rowOrColumn.forEachIndexed { index, cell ->
        this[cell] = newValues.getOrNull(index)
    }

    return originalValues != rowOrColumn.map { this[it] }
}

/*
 * Update the values stored in a board,
 * so that the values were "moved" to the specified direction
 * following the rules of the 2048 game .
 * Use the 'moveValuesInRowOrColumn' function above.
 * Return 'true' if the values were moved and 'false' otherwise.
 */
fun GameBoard<Int?>.moveValues(direction: Direction): Boolean {
    val range = 1..width
    val allChanged = when (direction) {
        Direction.UP -> (1..width).map { col ->
            val column = getColumn(range, col)
            moveValuesInRowOrColumn(column)
        }
        Direction.DOWN -> (1..width).map { col ->
            val column = getColumn(range, col).asReversed()
            moveValuesInRowOrColumn(column)
        }
        Direction.LEFT -> (1..width).map { row ->
            val rowCells = getRow(row, range)
            moveValuesInRowOrColumn(rowCells)
        }
        Direction.RIGHT -> (1..width).map { row ->
            val rowCells = getRow(row, range).asReversed()
            moveValuesInRowOrColumn(rowCells)
        }
    }
    return allChanged.any { it }
}
package board

import board.Direction.*

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)
fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)



open class SquareBoardImpl(override val width: Int) : SquareBoard {

    private val cells: Array<Array<Cell>> = Array(width) { row ->
        Array(width) { col -> Cell(row + 1, col + 1) }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if (i in 1..width && j in 1..width)
            cells[i - 1][j - 1]
        else
            null
    }

    override fun getCell(i: Int, j: Int): Cell {
        return getCellOrNull(i, j) ?: throw IllegalArgumentException("Invalid cell coordinates: ($i, $j)")
    }

    override fun getAllCells(): Collection<Cell> {
        return cells.flatten()
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        return jRange.mapNotNull { j -> getCellOrNull(i, j) }
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        return iRange.mapNotNull { i -> getCellOrNull(i, j) }
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        val (newI, newJ) = when (direction) {
            UP -> i - 1 to j
            DOWN -> i + 1 to j
            LEFT -> i to j - 1
            RIGHT -> i to j + 1
        }
        return getCellOrNull(newI, newJ)
    }
}

class GameBoardImpl<T>(width: Int) : GameBoard<T>, SquareBoardImpl(width) {
    private val values: MutableMap<Cell, T?> = super.getAllCells()
        .associateWith { null }
        .toMutableMap()

    override fun get(cell: Cell): T? = values[cell]

    override fun set(cell: Cell, value: T?) {
        values[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return values.filter { predicate(it.value) }.keys
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return filter(predicate).firstOrNull()
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return values.values.any(predicate)
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return values.values.all(predicate)
    }
}


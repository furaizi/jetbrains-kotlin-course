package module_5.assignment.games.gameFifteen.src.gameFifteen

import module_5.assignment.board.src.board.Direction
import module_5.assignment.board.src.board.GameBoard
import module_5.assignment.board.src.board.createGameBoard
import module_5.assignment.games.game.src.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
    GameOfFifteen(initializer)

class GameOfFifteen(private val initializer: GameOfFifteenInitializer) : Game {
    private val board: GameBoard<Int?> = createGameBoard(4)

    override fun initialize() {
        val initialNumbers = initializer.initialPermutation
        val iterator = initialNumbers.iterator()

        for (cell in board.getAllCells()) {
            board[cell] = if (iterator.hasNext()) iterator.next() else null
        }
    }

    override fun canMove(): Boolean = true

    override fun hasWon(): Boolean {
        val correctOrder = (1..15).toList()
        val currentOrder = board.getAllCells().mapNotNull { board[it] }
        return currentOrder == correctOrder
    }

    override fun processMove(direction: Direction) {
        val emptyCell = board.find { it == null } ?: return
        val neighbour = with(board) {
            emptyCell.getNeighbour(direction.reversed())
        }

        if (neighbour != null) {
            board[emptyCell] = board[neighbour]
            board[neighbour] = null
        }
    }

    override fun get(i: Int, j: Int): Int? = board[board.getCell(i, j)]
}


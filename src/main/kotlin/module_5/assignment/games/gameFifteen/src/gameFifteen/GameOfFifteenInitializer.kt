package module_5.assignment.games.gameFifteen.src.gameFifteen

interface GameOfFifteenInitializer {
    /*
     * Even permutation of numbers 1..15
     * used to initialized the first 15 cells on a board.
     * The last cell is empty.
     */
    val initialPermutation: List<Int>
}

class RandomGameInitializer : GameOfFifteenInitializer {
    /*
     * Generate a random permutation from 1 to 15.
     * `shuffled()` function might be helpful.
     * If the permutation is not even, make it even (for instance,
     * by swapping two numbers).
     */

    override val initialPermutation: List<Int> by lazy {
        var permutation: List<Int>
        do {
            permutation = (1..15).toList().shuffled()
        } while (!isEven(permutation))
        permutation
    }
}


package module_5.assignment.games.gameFifteen.test.gameFifteen

import module_5.assignment.games.gameFifteen.src.gameFifteen.RandomGameInitializer
import module_5.assignment.games.gameFifteen.src.gameFifteen.isEven
import org.junit.Assert
import org.junit.Test

class TestGameOfFifteenInitializer {
    @Test
    fun testInitialPermutationIsNotTrivial() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals("The initial permutation must not be trivial",
            (1..15).toList(), initializer.initialPermutation)
    }

    @Test
    fun testInitialPermutationIsEven() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals("The initial permutation must be even",
            isEven(initializer.initialPermutation)
        )
    }
}
package mastermind

data class Evaluation(var rightPosition: Int, var wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val evaluation = Evaluation(0, 0)
    var mutableSecret = secret
    var mutableGuess = guess

    for ((index, guessChar) in mutableGuess.withIndex()) {
        if (guessChar == mutableSecret[index]) {
            evaluation.rightPosition++
            mutableSecret = mutableSecret.replaceFirst(guessChar, ' ', false)
            mutableGuess = mutableGuess.replaceFirst(guessChar, ' ', false)
        }
    }

    for (guessChar in mutableGuess) {
        if (guessChar != ' ' && guessChar in mutableSecret) {
            evaluation.wrongPosition++
            mutableSecret = mutableSecret.replaceFirst(guessChar, ' ', false)
            mutableGuess = mutableGuess.replaceFirst(guessChar, ' ', false)
        }
    }

    return evaluation
}

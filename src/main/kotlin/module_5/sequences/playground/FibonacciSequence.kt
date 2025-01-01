package module_5.sequences.playground

import module_5.inline_functions.playground.eq

fun fibonacci(): Sequence<Int> = generateSequence(0 to 1) { (first, second) ->
    second to (first + second)
}.map { it.first }

fun main(args: Array<String>) {
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}
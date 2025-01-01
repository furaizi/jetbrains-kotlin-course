package module_5.sequences.playground

import module_5.inline_functions.playground.eq

fun fibonacci(): Sequence<Int> = sequence {
    var (first, second) = Pair(0, 1)
    while (true) {
        if (first < second) {
            yield(first)
            first += second
        }
        else {
            yield(second)
            second += first
        }
    }
}

fun main(args: Array<String>) {
    println(fibonacci().take(4).toList())
    fibonacci().take(4).toList().toString() eq
            "[0, 1, 1, 2]"

    fibonacci().take(10).toList().toString() eq
            "[0, 1, 1, 2, 3, 5, 8, 13, 21, 34]"
}
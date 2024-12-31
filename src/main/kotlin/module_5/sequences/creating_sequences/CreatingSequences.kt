package module_5.sequences.creating_sequences

import kotlin.random.Random

/*
interface Sequence<out T> {
    operator fun iterator(): Iterator<T>
}

Sequence doesn't belong to Iterable hierarchy
Extensions on sequences match extensions on collections
Intermediate operations aren't inlined, but terminal ones are

 */

fun main() {
    val seq = generateSequence { Random.nextInt(5).takeIf { it > 0 } }
    println(seq.toList())

    // Generating an infinite sequence
    val numbers = generateSequence(0) { it + 1 }
    println(numbers.take(5).toList())

    // yield
    val list = sequence {
        var x = 0
        while (true) {
            yield(x++)
        }
    }
    numbers.take(5).toList() // [0, 1, 2, 3, 4]

    /*
    sequence {
        yield(value)
        yieldAll(list)
        yieldAll(sequence)
    }
     */
}
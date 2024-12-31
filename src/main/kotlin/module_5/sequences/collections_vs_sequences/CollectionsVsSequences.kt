package module_5.sequences.collections_vs_sequences

/*
Extensions on collections are inlined
Like in Java, intermediate operations return new collections as a result

Sequences is an analogue of Java Streams
 */
val list = listOf(1, 2, -3)
val maxOddSquare = list
    .asSequence()
    .map{ it * it }
    .filter { it % 2 == 1}
    .max()
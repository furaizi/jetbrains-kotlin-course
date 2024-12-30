package module_4.conventions.conventions

/*
Comparisons

symbol              translated to
a > b               a.compareTo(b) > 0
a < b               a.compareTo(b) < 0
a >= b              a.compareTo(b) >= 0
a <= b              a.compareTo(b) <= 0
To use it, we need to define member or extension function compareTo marked with operator (with the right signature)
operator fun Point.compareTo(other: Point): Int {}
or just implement Comparable interface

s1 == s2
calls equals under the hood






Accessing elements by index []

x[a, b]             x.get(a, b)
x[a, b] = c         x.set(a, b, c)
operator fun Board.get(x: Int, y: Int): Char {}
operator fun Board.set(x: Int, y: Int, value: Char) {}






a in c      to          c.contains(a)
start..end  to          start.rangeTo(end)





operator fun CharSequence.iterator(): CharIterator
for (c in "abc")

val (first, second) = pair
for ((key, value) in map)
map.forEach { (key, value) -> }




Destructuring in lambdas
one parameter: { a -> ... }
two parameters: { a, b -> ... }
a destructured pair { (a, b) -> ... }
a destructured pair and another parameter { (a, b), c -> ... }




Iterating over list with index
fun <T> Iterable<T>.withIndex(): List<IndexedValue<T>> {}


Operator syntax works for all Java methods with the right signature
 */
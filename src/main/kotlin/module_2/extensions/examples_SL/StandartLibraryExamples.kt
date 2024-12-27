package module_2.extensions.examples_SL

/*
Kotlin standard library = Java standard library + extensions

Functions:
Iterable<T>.joinToString
Array<T>.getOrNull
Iterable<T>.withIndex()
infix Int.until -    1.until(10)     1 until 10
infix <A, B> A.to(that: B)


Extensions on String:

have text block like in Java
val q = """To code,
    |or not to code?..""".trimMargin()
to get normal alignment

regex
val regex = "\\w+".toRegex()
regex.matches("str") -> true

toInt()
toDouble()
toIntOrNull()
 */

fun main() {
    val set = hashSetOf(1, 7)
    println(set.javaClass) // class java.util.HashSet
}
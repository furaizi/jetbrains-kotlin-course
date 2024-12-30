package module_4.OOP.generics

interface List<E> {
    fun get(index: Int): E
}

// T can be either non-nullable or nullable type
fun <T> List<T>.filter(predicate: (T) -> Boolean): List<T>? = null


fun <T> List<T>.firstOrNull(): T? = null

// Non-nullable upper bound
fun <T : Any> foo(list: List<T>) {}

// We can combine nullable and non-nullable
fun <T : Any> List<T?>.filterNotNull(): List<T>? = null

/*
Different upper bounds
fun <T : Number> oneHalf(value: T): Double? {}
fun <T : Number?> oneHalf(value: T): Double? {}

fun <T : Comparable<T>> max(first: T, second: T): T {}


Multiple constraints for a type parameter
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {}

fun List<Int>.average(): Double {}
fun List<Double>.average(): Double {} // error

@JvmName("averageOfDouble")
fun List<Double>.average(): Double {} // ok
 */
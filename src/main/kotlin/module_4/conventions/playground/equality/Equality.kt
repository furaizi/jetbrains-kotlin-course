package module_4.conventions.playground.equality

data class Value(val s: String)

fun equals1(v1: Value?, v2: Value?): Boolean {
    return v1 == v2
}

fun equals2(v1: Value?, v2: Value?): Boolean = v1 === v2 || v1?.equals(v2) ?: false

infix fun Boolean.eq(statement: Boolean) = if (this == statement) println("OK") else println("NOT OK")

fun main(args: Array<String>) {
    equals1(Value("abc"), Value("abc")) eq true
    equals1(Value("abc"), null) eq false
    equals1(null, Value("abc")) eq false
    equals1(null, null) eq true

    equals2(Value("abc"), Value("abc")) eq true
    equals2(Value("abc"), null) eq false
    equals2(null, Value("abc")) eq false
    equals2(null, null) eq true
}
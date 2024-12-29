package module_3.functional_programming.function_types

val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val isEven = { i: Int -> i % 2 == 0 }
val result = isEven(42)


fun main() {
    // Calling lambda directly
    { println("Hi") }()

    // Better
    run { println("Hi") }
}

/*
Working with a nullable function type

val f: (() -> Int)? = null

f() // Compiler error

1. if (f != null)
    f()

2. f?.invoke()
 */
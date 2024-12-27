package module_2.basics

// function with block body
fun max1(a: Int, b: Int): Int {
    return if (a > b) a
            else b
}

/*
fun functionName(variableName1: variableType1, variableName2: variableType2): ReturnType {
    function body
}
 */

// function with expression body
fun max2(a: Int, b: Int): Int = if (a > b) a else b

// without explicit return type
fun max3(a: Int, b: Int) = if (a > b) a else b

// returns Unit (analogue of Void)
fun displayMax(a: Int, b: Int) {
    println(max1(a, b))
}

/*
In Kotlin you can define functions everywhere:
1. Top-level function
2. Member function
3. Local function

You can call a Kotlin top-level function from Java as a static function of the $filename.kt
If you dont want to show file name prefix for function invocation, you can use @JvmName annotation
@file:JvmName("Util")
 */

// Local function example
fun other() {
    fun local() = 3
}
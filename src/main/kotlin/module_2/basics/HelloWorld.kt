package module_2.basics

// no need for a class declaration to start the program


// "fun" key word for function declaration
// no need for args and return type
fun main() {
    // "val" key word for variable declaration
    // no need for semicolon (;)
    val name = "Kotlin"

    // has string interpolation
    // no need for System.out object invoking to print text to console
    println("Hello, $name!")
}

// if you need, you can specify args array in main function parameters
// also, main function with args array has a higher priority if both are declared in the file
// there is no special built-in syntax for arrays. Its the same array as in Java
// however, in the code, Array looks like a regular class with generic arguments
fun main(args: Array<String>) {

    // if/else now is an expression, so you can assign its value to a variable
    val name = if (args.size > 0) args[0]
                else "Kotlin"
    println("Hello, $name!")
}

/*
String templates

"...$variable..."
"...${functionCall(...)}..."

println("Hello, ${null}!") -> Hello, null!
 */

fun foo(): String {
    println("Calculating foo")
    return "foo";
}

fun newMain() {
    println("First ${foo()}, second ${foo()}") // It will invoke "foo()" twice, so there is no unexpected optimizations or caching
}
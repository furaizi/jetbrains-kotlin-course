package module_5.inline_functions.power_of_inline

import java.io.BufferedReader
import java.io.FileReader

/*
Regular non-inlined lambdas create an anonymous class every time when they are invoked
"inline" function means that compiler substitutes a body of the function instead of calling it (like in C++)

Kotlin doesn't have "synchronized", but has function Lock.withLock{ lambda }
Functions won't be inlined in the bytecode if you call them from Java

@InlineOnly - specifies that this function shouldn't be called directly without inlining
Use "inline" with care, only with small functions, because inlining enlarges JAR file size
 */

fun myRun(f: () -> Unit) = f()

fun main(args: Array<String>) {
    val name = "Kotlin"

    // brings performance overhead
    myRun { println("Hi, $name") }

    // in comparison to
    println("Hi, $name")
}

// Resource management: "use" function
fun readFirstLineFromFile(path: String) = BufferedReader(FileReader(path)).use { reader ->  reader.readLine() }
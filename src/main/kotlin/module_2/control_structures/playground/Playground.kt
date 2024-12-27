package module_2.control_structures.playground

import java.util.regex.Pattern

fun isValidIdentifier(s: String): Boolean {
    return s.isNotEmpty() && Pattern.matches("[a-zA-Z_]", s[0].toString()) && Pattern.matches("\\w+", s)
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

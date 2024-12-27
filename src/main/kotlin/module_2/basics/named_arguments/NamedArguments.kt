package module_2.basics.named_arguments

// named arguments
fun main() {
    println(listOf('a', 'b', 'c').joinToString(
        separator = "", prefix = "(", postfix = ")"
    ))

    println(listOf(1, 2, 3).joinToString(postfix = "."))
}
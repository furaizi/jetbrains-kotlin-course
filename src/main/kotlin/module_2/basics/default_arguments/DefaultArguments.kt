package module_2.basics.default_arguments

fun main() {
    displaySeparator()
    // you cant implicitly convert an integer to a character or vice versa
    // displaySeparator(3, '5') -> compiler error
}

fun displaySeparator(character: Char = '*', size: Int = 10) {
    repeat(size) {
        println(character)
    }
}

/*
by default, you cant use function with default arguments from Java
but if you want, use @JvmOverloads annotations
 */
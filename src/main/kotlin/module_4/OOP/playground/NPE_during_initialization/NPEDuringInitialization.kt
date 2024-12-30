package module_4.OOP.playground.NPE_during_initialization

open class A(open val value: String) {
    init {
        println(value.uppercase())
    }
}

class B(override val value: String) : A(value)

fun main(args: Array<String>) {
    B("a")
}
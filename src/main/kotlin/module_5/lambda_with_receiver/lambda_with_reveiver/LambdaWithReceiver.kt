package module_5.lambda_with_receiver.lambda_with_reveiver

/*
Lambda with receiver = extension function + lambda
Lambda with receiver is lambda with implicit "this"
Sometimes it is called extension lambda
 */

fun main() {
    val sb = StringBuilder()
    with (sb) {
        appendln("Alphabet")
        'a'..'z'.apply(sb::append)
    }

    with (sb) {
        this.appendln("Alphabet")
        'a'..'z'.apply(sb::append)
        this.toString()
    }

    val isEven: (Int) -> Boolean = { it % 2 == 0 }
    val isOdd: Int.() -> Boolean = { this % 2 == 1 }
    isEven(0)
    1.isOdd()


    val s: String = buildString {
        appendLine("Alphabet")
        'a'..'z'.apply(this::append)
    }
}
inline fun buildStringDemo(builderAction: StringBuilder.() -> Unit): String = ""
inline fun <T, R> withDemo(receiver: T, block: T.() -> R): R = receiver.block()
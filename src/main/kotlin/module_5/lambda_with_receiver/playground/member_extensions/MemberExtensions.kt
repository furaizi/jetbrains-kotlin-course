package module_5.lambda_with_receiver.playground.member_extensions

import module_5.inline_functions.playground.eq

class Words {
    private val list = mutableListOf<String>()

    internal operator fun String.unaryPlus(): Boolean = list.add(this)
    internal fun String.record(): Boolean = +this

    override fun toString() = list.toString()
}

fun main(args: Array<String>) {
    val words = Words()
    with(words) {
        // The following two lines should compile:
        "one".record()
        +"two"
    }
    words.toString() eq "[one, two]"
}
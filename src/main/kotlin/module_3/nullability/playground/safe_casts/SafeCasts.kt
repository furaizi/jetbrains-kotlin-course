package module_3.nullability.playground.safe_casts

fun main(args: Array<String>) {
    val s = ""
    println(s as? Int)    // null
    println(s as Int?)    // exception
}
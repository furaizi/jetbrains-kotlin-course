package module_3.nullability.playground

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() eq true
    s2.isEmptyOrNull() eq true

    val s3 = "   "
    s3.isEmptyOrNull() eq false
}

private infix fun Boolean.eq(b: Boolean) {
    if (this == b)
        println("OK")
    else
        println("NOT OK")
}

fun String?.isEmptyOrNull() : Boolean {
    return this?.isEmpty() ?: true
}
package module_3.assignment.nice_string.src.nicestring

fun String.isNice(): Boolean {
    val conditions = listOf(
        doesNotContainForbiddenSubstrings,
        hasAtLeastThreeVowels,
        hasDoubleLetter
    )
    return conditions.count{ it(this) } >= 2
}


val doesNotContainForbiddenSubstrings : (String) -> Boolean = { str ->
    listOf("bu", "ba", "be")
        .none { str.contains(it) }
}
val hasAtLeastThreeVowels : (String) -> Boolean = { str ->
    str.count { it in "aeiou" } >= 3
}
val hasDoubleLetter : (String) -> Boolean = { str ->
    str.zipWithNext()
        .any { it.first == it.second }
}
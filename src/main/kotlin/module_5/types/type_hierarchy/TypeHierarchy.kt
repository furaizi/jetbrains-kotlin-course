package module_5.types.type_hierarchy

/*
Any is a super class for all types
Nothing is a sub-type for all the other types
Unit = void
Nothing means "this function never returns, it only throws an exception"
 */

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun infiniteLoop(): Nothing {
    while (true) {}
}

// val name = person.name ?: return
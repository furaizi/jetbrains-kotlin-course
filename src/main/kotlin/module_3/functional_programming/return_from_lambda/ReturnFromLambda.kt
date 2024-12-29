package module_3.functional_programming.return_from_lambda

/*
Returning in Kotlin always returns from a function marked with "fun", it doesn't work with lambdas

If you want to use "return" with lambda, you need to add annotation with lambda's name after "return"

list.flatMap {
    if (it == 0) return@flatMap listOf<Int>()
    listOf(it, it)
}

or

list.flatMap l@{
    if (it == 0) return@l listOf<Int>()
    listOf(it, it)
}

Anonymous function
return list.flatMap(fun (e): List<Int> {
    if (e == 0) return listOf()
    return listOf(e, e)
})
 */
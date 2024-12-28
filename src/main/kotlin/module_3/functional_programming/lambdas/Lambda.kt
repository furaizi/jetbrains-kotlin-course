package module_3.functional_programming.lambdas

/*
Java:
button.addActionListener(action -> sout("Hi"))

Kotlin:
button.addActionListener { sout("Hi") }

Syntax

{ x: Int, y: Int -> x + y }
list.any({ i: Int -> i > 0 })

When lambda is the last argument, it can be moved out of parentheses
list.any() { i: Int -> i > 0 }
Empty parentheses can be omitted
list.any { i: Int -> i > 0 }
list.any { i -> i > 0 }
list.any { it > 0 }

Multi-line lambda
list.any {
    println("x...")
    it > 0
}

Destructuring declarations
map.mapValues { entry -> "${entry.key} = ${entry.value}" }
map.mapValues { (key, value) -> "$key = $value" }
map.mapValues { (_, value) -> "$value" } // if one of the parameters is unused
 */
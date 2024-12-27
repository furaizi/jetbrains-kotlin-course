package module_2.control_structures.conditionals

/*
No ternary operator

switch -> when
default -> else
no case
you can check multiply options in branch condition
when (input) {
    "y", "yes" -> "I'm glad you agree"

}

Any expression can be used as a branch condition
when (setOf(c1, c2)) {
    setOf(RED, YELLOW) -> ORANGE
    else -> throw Exception("Dirty color")
}

Checking types
when (pet) {
    is Cat -> pet.meow() // smart cast
    is Dog -> pet.woof()
}

Capturing when subject in a variable
when (val pet = getMyPet()) {
    is Cat -> pet.meow() // smart cast
    is Dog -> pet.woof()
}

Checking conditions: when without argument
when {
    degrees < 5 (any boolean expression) -> do()
    else -> otherwise()
}
 */
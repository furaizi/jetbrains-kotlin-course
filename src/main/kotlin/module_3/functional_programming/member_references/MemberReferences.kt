package module_3.functional_programming.member_references

/*
Kotlin, like Java, has member (method) references

people.maxBy { it.age }
people.maxBy(Person::age)


You can store lambda in a variable, but not a function
But you can store member (method) reference in a variable

val predicate = ::isEven

 */

class Person(val name: String, val age: Int) {
    fun isOlder(ageLimit: Int) = age > ageLimit
    fun getAgePredicate() = ::isOlder
}

val alice = Person("Alice", 29)
val nonBoundAgePredicate1: (Person, Int) -> Boolean = { person, ageLimit -> person.isOlder(ageLimit) }
val nonBoundAgePredicate2: (Person, Int) -> Boolean = Person::isOlder
val boundAgePredicate2: (Int) -> Boolean = { ageLimit -> alice.isOlder(ageLimit) }
val boundAgePredicate1: (Int) -> Boolean = alice::isOlder

fun main() {
}
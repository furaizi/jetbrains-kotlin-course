package module_4.OOP.class_modifiers

/*
enum class Color {
    BLUE, ORANGE, RED
}

enum class with properties
enum class Color(val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255), ORANGE(255, 165, 0), RED(255, 0, 0);

    fun rgb() = (r * 256 + g) * 256 + b
}

"data" class
generates equals, hashCode, copy, toString

data class Contact(val name: String, val address: String)
contact.copy(address = "new address")


== calls equals
=== checks reference equality

If you want to ignore a property during "equals", "toString", etc, you need to declare it inside the class body
data class User(val email: String) {
    var nickname: String? = null
}
 */


/*
Second part

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

"sealed" modifier restricts class hierarchy: all subclasses must be located in the same file


In Java                 In Kotlin               Class declared within another class
static class A          class A (by default)    nested class
class A (by default)    inner class A           inner class

"inner" modifier adds a reference to the outer class
class A {
    class B
    inner class C {
        ...this@A...
    }
}


Class delegation
class Controller(repository: Repository, logger: Logger) : Repository by repository, Logger by logger
implements an interface by delegating to...
 */
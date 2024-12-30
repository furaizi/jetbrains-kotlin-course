package module_4.OOP.objects_companions

/*
Object is a singleton in Kotlin
 */

// Object declaration
object KSingleton {
    fun foo() {}
}

fun main() {
    KSingleton.foo()
}

/*
To use Kotlin object from Java
KSingleton.INSTANCE.foo();
 */

/*
Object expressions replace Java's anonymous classes
window.addMouseListener(
    object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            ...
        }
        override fun mousePressed(e: MouseEvent) {
            ...
        }
    }
)
A new instance of object expression is created for each call
 */

/*
Companion object is like nested object
                 is a special object inside a class

It is a replacement to static methods in Java
 */



// You can call companion's methods by class name
class A {
    companion object {
        fun foo() = 1
    }
}
fun main(args: Array<String>) {
    A.foo()
}


// Companion object can implement an interface
interface Factory<T> {
    fun create(): T
}

class B private constructor() {

    companion object : Factory<B> {
        override fun create() = B()
    }
}



// Companion object can be a receiver of extension function
class Person(val firstName: String, val lastName: String) {
    companion object {
        fun fromJSON(json: String) = ""
    }
}

fun Person.Companion.fromJSON(json: String) = "override"


/*
There is no static keyword
Declare "static" members:
    - at the top-level
    - inside objects
    - inside companion objects

@JvmStatic for companion's methods to use them from Java
or add Companion
C.Companion.foo();
 */
package module_4.OOP.constructors_inheritance

/*
Objects are created without "new"
val a = A()

Primary constructor
class Person(val name: String, val name: Int)

Full primary constructor
class Person(name: String) {
    val name: String

    init {
        this.name = name
    }
}

You can change visibility of a constructor
class InternalComponent
internal constructor(name: String) {
    ...
}

Secondary constructor
class Rectangle(val height: Int, val width: Int) {

    constructor(side: Int) : this(side, side) {
        ...
    }
}

Inheritance
The same syntax for "extends" & "implements"
interface Base
class BaseImpl : Base

open class Parent
class Child : Parent()

open class Parent(val name: String)
class Child(name: String) : Parent(name)

open class Parent(val name: String)
class Child : Parent {
    constructor(name: String, param: Int) : super(name)
}

In Kotlin you can override a property
It doesn't override a field but a getter
 */
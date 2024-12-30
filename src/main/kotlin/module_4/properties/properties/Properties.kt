package module_4.properties.properties

/*
Property is a field of the class with a getter and a setter

val = field + getter
var = field + getter + setter

You dont call getters or setters when using a property, just use it like a variable
You also can create a property without a field
val = getter
var = getter + setter

val isSquare: Boolean
    get() {
        return height == width
    }

You can access field only inside accessors
var state = false
    set(value) {
        println("$field -> $value")
        field = value
    }


Changing visibility of a setter
var counter: Int = 0
    private set
 */
package module_4.properties.more

/*
You can define properties in an interface
interface User {
    val nickname: String
}

class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@")
}

Open property can't be used in smart casts
if (session.user is FacebookUser)
    println(session.user.accountId)     // error

Solution:
val user = session.user
if (user is FacebookUser)
    println(user.accountId)


Extension properties
val String.lastIndex: Int
    get() = this.length - 1
    set(value: Int) {   // bad example but okay
        field = value
    }
 */
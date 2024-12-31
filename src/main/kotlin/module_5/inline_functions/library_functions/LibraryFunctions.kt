package module_5.inline_functions.library_functions

/*
Useful library functions:
run - runs the block of code (lambda) and returns the last expression as the result
let - allows to check the argument for being non-null, not only the receiver
takeIf - returns the receiver object if it satisfies the given predicate, otherwise returns null
takeUnless
repeat

All these functions are declared as "inline" functions
inline fun <R> run(block: () -> R): R = block()
 */

val foo = run {
    println("Calculating foo")
    "foo"
}


/*
fun getEmail(): Email?
val email = getEmail()

if (email != null) sendEmailTo(email)
or
email?.let { e -> sendEmailTo(e) }
getEmail()?.let { sendEmailTo(it) }


val user = session.user
if (user is FacebookUser)
    println(user.accountId)
or
(session.user as? FacebookUser)?.let { println(it.accountId) }
 */
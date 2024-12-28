package module_3.nullability.nullable_types

/*
There are nullable and non-nullable types in Kotlin
val s1 = "always not null"
val s2 : String? = null

s1.length ok
s2.length no (can be null)

if (s2 != null)
    s2.length   ok
But better:
s2?.length // safe access (or safe call)
If s2 == null, then null be returned

 */

val s: String? = null
val length: Int? = s?.length
val intLength: Int = s?.length ?: 0 // Elvis operator

/*
Elvis operator:
foo ?: bar
if (foo != null)
    foo
else
    bar

sum operator has higher priority than elvis one
 */

/*
Control-flow analysis

val s: String?

if (s == null) return
s.length // smart cast
 */

/*
Not-null assertion
foo!!
if (foo != null)
    foo
else
    throw Null Pointer Exception

val s: String?
s!!.length  // ok

Advice: dont put two or more !! in one line since you cant find out which !! caused NPE
 */
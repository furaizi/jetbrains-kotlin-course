package module_4.conventions.operator_overloading

/*
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}
Point(1, 2) + Point(3, 5)

Expression          Function name
a + b                   plus
a - b                   minus
a * b                   times
a / b                   div
a % b                   mod

+a                      unaryPlus
-a                      unaryMinus
!a                      not
++a, a++                inc
--a, a--                dec

a += b                  plusAssign or plus


There is no restrictions on parameter type
operator fun Point.plus(scale: Int): Point {
    return Point(x * scale, y * scale)
}
Point(1, 2) * 3
 */

val list = listOf(1, 2, 3)
val newList = list + 2

val mutableList = mutableListOf(1, 2, 3)
// mutableList += 4
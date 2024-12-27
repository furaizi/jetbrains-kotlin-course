package module_2.control_structures.`in`

/*

in: two use cases
1. iteration
2. check for belonging
c in 'a'..'z'
c !in '0'..'9'


You can use "in" in "when"
when (c) {
    in 'a'..'z', in 'A'..'Z' -> do()
}

1..9, 1 until 10 IntRange
'a'..'z' CharRange
"ab".."az" ClosedRange<String>
startDate..endDate ClosedRange<MyDate>


"Kotlin" in "Java".."Scala" // true


To use a range of custom types, the class you are creating must implement Comparable<$Type>
class MyDate : Comparable<MyDate>


Belonging to collection
if (element in list)
 */
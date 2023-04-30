package rsk

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5)
    val greaterThanThree = { it: Int -> it > 3 }

//    Writing predicate directly
    println(ints.all { it > 3 })
    println(ints.any { it > 3 })
    println(ints.count { it > 3 })

//    Using predicate as variable
    println(ints.all(greaterThanThree))
    println(ints.any(greaterThanThree))
    println(ints.count(greaterThanThree))
    println(ints.find(greaterThanThree))
    println(ints.find { it > 6 })

    var found: Int? = ints.find(greaterThanThree)
    println(found)
    found = ints.find { it > 6 }
    println(found)
}
package rsk

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5)
    val smallInts = ints.filter { it < 4 }
    smallInts.forEach { println(it) }

    val squaredInts = ints.map { it }
    squaredInts.forEach { println(it) }

    val smallSquaredInts = ints
        .filter { it < 5 }
        .map { it }

    smallSquaredInts.forEach { println(it) }
}
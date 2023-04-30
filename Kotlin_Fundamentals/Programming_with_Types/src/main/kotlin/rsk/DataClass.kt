package rsk

fun main(args: Array<String>) {
    var kevin = Pupil(1, "kevin")
    var jones = Pupil(1, "kevin")

    println(kevin)

    if (kevin == jones) {
        println("equal")
    } else {
        println("not equal")
    }

    var newKevin = kevin.copy(name = "robert")
    println(newKevin)
}

data class Pupil(val id: Int, val name: String) {

}
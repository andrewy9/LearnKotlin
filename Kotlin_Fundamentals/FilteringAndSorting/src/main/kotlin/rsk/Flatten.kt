package rsk

fun main(args: Array<String>) {
    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"))

    val people = meetings
        .flatMap { it -> it.people }
        .distinct()
    //the People class is a data class
    people.forEach { println(it.name) }

}
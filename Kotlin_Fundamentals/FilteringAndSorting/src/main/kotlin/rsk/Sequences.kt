package rsk

fun iter(seq: Sequence<String>) {
    seq.forEach(::println)
}

fun main(args: Array<String>) {
    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committee Meeting"))

    val titles = meetings
        .asSequence()
        .filter { println("fiter($it)"); it.title.endsWith("g") }
        .map { println("map($it)"); it.title }

    iter(titles)

//    val title = meetings
//        .asSequence()
//        .map { println("map($it)"); it.title.uppercase(Locale.getDefault()) }
//        .find { it.startsWith("BOARD") }
//
//    println(title)
}

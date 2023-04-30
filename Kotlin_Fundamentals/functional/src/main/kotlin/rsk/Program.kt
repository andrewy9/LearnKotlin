package rsk

fun main(args: Array<String>) {
    var program = Program()
//    program.fibonacci(8)
//    program.fibonacci(8, object : Process{
//        override fun execute(value: Int) {
//            println("$value _byStrategy")
//        }
//    })

    fun example(int: Int, str: String) {
        println(int)
        println(str)
    }

//    program.fibonacci(10, ::example)

    var m = Meeting("auck", "3pm")

    print(m.apply{
        place = "welly"
    }.place)

}

interface Process {
    fun execute(value: Int)
}

class Meeting (var place:String, var time: String)

class Program {
    fun fibonacci(limit: Int, action: Process) {
        var prev = 0;
        var prevprev = 0;
        var current = 1;

        for (i: Int in 1..limit) {
            action.execute(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci(limit: Int, func: (Int, String) -> Unit) {
        var prev = 0;
        var prevprev = 0;
        var current = 1;

        for (i: Int in 1..limit) {
            func(current, "test")

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }

    }
}
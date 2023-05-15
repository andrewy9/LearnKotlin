import kotlinx.coroutines.*
import java.lang.Thread.sleep
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

const val num_tasks = 10_000
const val loops = 500
const val wait_ms = 10L

fun main() = runBlocking {
    println("Starting")

    val result = AtomicInteger()
    val jobs = mutableListOf<Job>()
    var totalLoopCount = AtomicInteger()

    for (i in 1..num_tasks) {
        jobs.add(launch(Dispatchers.IO) {
            print("job $i added: running loops")
            for (x in 1..loops) {
                delay(wait_ms)
                println("loop is done: $x")
                totalLoopCount.getAndIncrement()
            }
        })
        result.getAndIncrement()
        println("mid num loop: " + result.get())
    }

    jobs.forEach { it.join() }
    println(result.get())
    println(totalLoopCount.get())
}

fun old_main(args: Array<String>) {
    println("Starting")

    val result = AtomicInteger()
    val threads = mutableListOf<Thread>()

    for (i in 1..num_tasks) {
        threads.add(thread {
            for (x in 1..loops) {
                sleep(wait_ms)
            }
        })
        result.getAndIncrement()
    }

    threads.forEach { it.join() }
    println(result.get())
}
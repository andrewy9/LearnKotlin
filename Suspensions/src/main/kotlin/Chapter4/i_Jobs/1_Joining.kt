package Chapter4.i_Jobs

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
//    waitByDelay() // -> "Hello, " OR "Hello World"
//    waitByJoin() // -> "Hello, World!!!"
//    cancellation() //-> .......Done
    timeOut() //
}

/**
 * Sometimes we don't know how long a CoRoutine will take, and we don't know how long we will have to
 * wait until the CoRoutine returns.
 *
 * In this example, the waitByDelaying() will either return "Hello, World!!!" or "Hello, !!!World"
 */
fun waitByDelay() = runBlocking {
    launch {
        var delayDuration = Random.nextInt(500, 1500).toLong();
        delay(delayDuration)
        print("World")
    }
    print("Hello, ")

    delay(1000)
    print("!!!")
}

/**
 * The .join() is a "cancellable" suspend function which causes the running CoRoutine
 * to wait until the CoRoutine it is joined to has finished
 */
fun waitByJoin() = runBlocking {
    val job: Job = launch {
        delay(5000)
        print("World")
    }
    print("Hello, ")

    job.join()
    print("!!!")
}
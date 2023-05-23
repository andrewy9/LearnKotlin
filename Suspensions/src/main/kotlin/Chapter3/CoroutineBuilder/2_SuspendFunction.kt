package Chapter3.CoroutineBuilder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun suspendFunction() = runBlocking {
    launch {
        delay(1000)
        println("world")
    }

    println("Hello, ")
    doWork()
}

/**
 * Suspend functions needs to be in either a CoroutineScope or another suspend function
 */
suspend fun doWork() {
    delay(1500)
}

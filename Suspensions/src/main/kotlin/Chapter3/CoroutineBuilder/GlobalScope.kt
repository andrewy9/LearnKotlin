package Chapter3.CoroutineBuilder

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
//    globalScope() // -> "Hello ,"
//    runBlocking_nonIdiomatic() // -> "Hello, World!!!"
    runBlocking_idiomatic() // -> "Hello, World!!!"

}

/**
 * GlobalScope.launch is non-blocking coroutine scope which returns immediately.
 * This means that methods within launch aren't waited for before the parent function finishes running.
 *
 * In this example, neither print("World") nor print("!!!") will run as the globalScope() method will not
 * wait for the GlobalScope.launch methods to finish.
 */
fun globalScope() {
    GlobalScope.launch {
        delay(10000)
        print("World")
    }
    print("Hello, ")

    GlobalScope.launch {
        delay(11000)
        println("!!!")
    }
}

/**
 * The runBlocking is a coroutine scope which blocks the main thread until the coroutines inside are complete.
 * This allows suspend functions such as delay() to be used instead of a blocking functions such as Thread.sleep().
 *
 * However, this is NOT the best practice to use runBlocking. More proper usage example below.
 */
fun runBlocking_nonIdiomatic() {
    GlobalScope.launch {
        delay(10000)
        print("World")
    }
    print("Hello, ")

    runBlocking {
        delay(11000)
        println("!!!")
    }
}

/**
 * A typical way of wirting runBlocking Coroutine builder
 */
fun runBlocking_idiomatic() = runBlocking {
    launch {
        delay(1000)
        print("World")
    }
    print("Hello, ")

    delay(1500)
    println("!!!")
}

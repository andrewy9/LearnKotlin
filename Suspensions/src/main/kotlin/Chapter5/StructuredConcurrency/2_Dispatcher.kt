package Chapter5.StructuredConcurrency

import kotlinx.coroutines.*
import java.util.concurrent.Executors

val dispatcher = Executors.newCachedThreadPool().asCoroutineDispatcher()
val executor = Executors.newFixedThreadPool(10)

fun dispatcher() = runBlocking<Unit> {
    val jobs = arrayListOf<Job>()

    jobs += launch {
        println(" 'default': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.Default) {
        println(" 'defaultDispatcher': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.IO) {
        println(" 'IO Dispatcher': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(Dispatchers.Unconfined) {
        println(" 'Unconfined': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(newSingleThreadContext("OwnThread")) {
        println(" 'newSTC': In thread ${Thread.currentThread().name}")
    }

    jobs += launch(dispatcher) {
        println(" 'cachedThreadPool': In thread ${Thread.currentThread().name}")
    }
    jobs += launch(executor.asCoroutineDispatcher()) {
        println(" 'fixedThreadPool': In thread ${Thread.currentThread().name}")
    }

    jobs.forEach{ it.join()}

    println()
    println()
    println()


    executor.shutdown()
    dispatcher.close()
}
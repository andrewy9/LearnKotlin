package Chapter4.Jobs

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

fun timeOut() = runBlocking{
    val job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()

            print(".")
            Thread.sleep(1)
        }
    }

    if(job == null) {
        println("Builder timed-out")
    }
}
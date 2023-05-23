package Chapter4.Jobs

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Job.cancel() method stops the co-routine early in a cooperative way so that it closes
 * naturally. Job.join() then waits for the co-routine to finish.
 *
 * Job.cancelAndJoin() is the amalgamation of the two methods.
 */
fun cancellation() = runBlocking<Unit> {
    val job = launch {
        repeat(1000) {
            delay(10)
            print(".")
        }
    }
    delay(250)

    job.cancelAndJoin();
    println("done")

    /** non idiomatic
     * job.cancel()
     * job.join()
     * println("done")
     **/
}
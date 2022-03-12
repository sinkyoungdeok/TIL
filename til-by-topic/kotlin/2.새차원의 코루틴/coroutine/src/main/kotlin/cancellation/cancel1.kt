package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    var job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel()
    job.join()
    println("main: Now I can quit.")
}


package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    yield()
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } catch (e: Exception) {
            kotlin.io.println("Exception [$e]")
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}


package cancellation

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        // 이 방법은 exception을 던지지 않는다.
        var nextPrintTime = startTime
        var i = 0
        println("isActive $isActive ...")
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
        println("isActive $isActive ...")
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")
}


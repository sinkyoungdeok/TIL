package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = GlobalScope.launch {
        delay(3000L)
        println("World!")
    }

    println("Hello,")
    job.join()
}



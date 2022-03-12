package basic

import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
    runBlocking {
        delay(2000L)
    }
}


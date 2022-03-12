package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    this.launch {
        delay(1000L)
        println("World!")
    }

    this.launch {
        delay(1000L)
        println("World!")
    }

    println("Hello,")
}



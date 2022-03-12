package basic

import kotlinx.coroutines.*

fun main() = runBlocking {
    this.launch {
        myWorld()
    }

    println("Hello,")
}

suspend fun myWorld() {
    delay(1000L)
    println("world.")
}


package basic

import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    thread {
        Thread.sleep(1000L)
        println("World!")
    }

    println("Hello,")
    Thread.sleep(2000L)
}


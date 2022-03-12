package context

import kotlinx.coroutines.*

fun main() = runBlocking<Unit>() {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}


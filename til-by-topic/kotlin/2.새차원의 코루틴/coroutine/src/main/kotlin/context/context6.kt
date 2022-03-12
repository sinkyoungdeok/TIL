package context

import kotlinx.coroutines.*

// 부모 코루틴은 자식코루틴이 끝나는 것을 기다린다.
fun main() = runBlocking<Unit>() {
    val request = launch {
        repeat(3) { i ->
            launch {
                delay((i+1) * 200L)
                println("Coroutine $i is done")
            }
        }
        println("request: I'm done and I don't explicitly join my children thread")
    }
    println("Now processing of the request is complete")
}


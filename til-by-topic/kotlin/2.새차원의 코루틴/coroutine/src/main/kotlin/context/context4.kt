package context

import kotlinx.coroutines.*

// 여러 다른 쓰레드를 하나의 코루틴으로 처리
fun main() = runBlocking<Unit>() {
    println("My job is ${coroutineContext[Job]}")

    launch {
        println("My job is ${coroutineContext[Job]}")
    }

    async {
        println("My job is ${coroutineContext[Job]}")
    }
}


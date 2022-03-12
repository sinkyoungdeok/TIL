package context

import kotlinx.coroutines.*

// 여러 다른 쓰레드를 하나의 코루틴으로 처리
fun main() = runBlocking<Unit>() {
    val request = launch {

        GlobalScope.launch { // 글로벌 스코프라 종료가 안됨. ( main이 아니다.)
            println("job1: I run in GlobalScope and execute independently!")
            delay(1000)
            println("job1: I am not affected by cancellation of the request")
        }

        launch {
            delay(100)
            println("job2: I am a child of the request coroutine")
            delay(1000)
            println("job2: I will not execute this line if my parent request is cancelled")
        }
    }
    delay(500)
    request.cancel()
    delay(1000)
    println("main: Who has survived request cancellation?")
}


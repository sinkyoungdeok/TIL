package context

import kotlinx.coroutines.*

fun log3(msg: String) = println("[${Thread.currentThread().name}] $msg")

// 여러 다른 쓰레드를 하나의 코루틴으로 처리
fun main()  {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->

            runBlocking (ctx1) {
                log("Started in ctx1")

                withContext(ctx2) {
                    log("Working in ctx2")
                }

                log("Back to ctx1")
            }
        }
    }
}


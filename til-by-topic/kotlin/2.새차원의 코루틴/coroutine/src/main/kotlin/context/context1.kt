package context

import kotlinx.coroutines.*


fun main() = runBlocking<Unit> {
    launch { // runblocking와 같은 컨텍스트에서 실행됨(main)
        println("main runBlocking   :" +
                " I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Unconfined) {
        println("Unconfined     :" +
                " I'm working in thread ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("Default        " +
                "I'm working in thread ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("MyOwnThread")) {
        println("newSingleThreadContext:" +
                " I'm working in thread ${Thread.currentThread().name}")
    }

    newSingleThreadContext("MyOwnThread").use {
        launch (it) {
            println("newSingleThreadContext:" +
                    " I'm working in thread ${Thread.currentThread().name}")
        }
    }
}


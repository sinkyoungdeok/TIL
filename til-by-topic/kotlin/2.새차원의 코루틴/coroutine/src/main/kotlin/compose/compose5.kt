package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    try {
        val time = measureTimeMillis {
            println("The answer is ${concurrentSum()}")
        }
        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(10000)
    }
}

suspend fun concurrentSum(): Int = coroutineScope { // coroutineScope를 사용함으로써 exception이 발생하면 전체 코루틴이 취소된다.
    val one = async { doSomethingUsefulOne5() }
    val two = async { doSomethingUsefulTwo5() }

    delay(10)
    println("Exception")
    throw Exception()

    one.await() + two.await()
}

suspend fun doSomethingUsefulOne5(): Int {
    println("doSomethingUsefulOne - START")
    delay(3000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo5(): Int {
    println("doSomethingUsefulTwo - START")
    delay(3000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

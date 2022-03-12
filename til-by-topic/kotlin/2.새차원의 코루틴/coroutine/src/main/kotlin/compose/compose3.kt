package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async (start = CoroutineStart.LAZY){ doSomethingUsefulOne3() }
        val two = async (start = CoroutineStart.LAZY){ doSomethingUsefulTwo3() }

        println("START")
        delay(2000L)
        one.start()
        two.start()

        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne3(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo3(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

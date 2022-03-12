package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
//        delay(2000L)
//        println("test..")
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

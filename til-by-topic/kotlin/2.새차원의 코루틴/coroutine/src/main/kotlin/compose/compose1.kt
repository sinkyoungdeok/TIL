package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUseFulOne()
        val two = doSomethingUseFulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUseFulOne(): Int {
    println("doSomethingUsefulOne - START")
    delay(1000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUseFulTwo(): Int {
    println("doSomethingUsefulTwo - START")
    delay(1000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

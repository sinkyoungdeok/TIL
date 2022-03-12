package compose

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// 이렇게 쓰면 안된다 라는 예제를 보여준것임. GlobalScope.async를 하게 되면 exception이 발생했음 에도 불구하고 코루틴이 계속 실행되는것을 볼 수 있음
fun main() {
    try {
        val time = measureTimeMillis {
            val one = somethingUsefulOneAsync4()
            val two = somethingUsefulTwoAsync4()

            println("my exceptions")
            throw Exception("my exceptions")

            runBlocking {
                println("The answer is ${one.await() + two.await()}")
            }
        }
        println("Completed in $time ms")
    } catch (e: Exception) {

    }

    runBlocking {
        delay(100000)
    }
}

fun somethingUsefulOneAsync4() = GlobalScope.async {
    println("start, somethingUsefulOneAsync")
    val res = doSomethingUsefulOne4()
    println("end, somethingUsefulOneAsync")
    res
}

fun somethingUsefulTwoAsync4() = GlobalScope.async {
    println("start, somethingUsefulTwoAsync")
    val res = doSomethingUsefulTwo4()
    println("end, somethingUsefulTwoAsync")
    res
}

suspend fun doSomethingUsefulOne4(): Int {
    println("doSomethingUsefulOne - START")
    delay(3000L)
    println("doSomethingUsefulOne - END")
    return 13
}

suspend fun doSomethingUsefulTwo4(): Int {
    println("doSomethingUsefulTwo - START")
    delay(3000L)
    println("doSomethingUsefulTwo - END")
    return 29
}

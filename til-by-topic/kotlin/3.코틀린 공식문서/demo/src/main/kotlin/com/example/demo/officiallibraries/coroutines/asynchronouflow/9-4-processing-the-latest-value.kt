package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun simple9dash4(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple9dash4()
            .collectLatest {
                println("Collection $it")
                delay(300)
                println("Done $it")
            }
    }
    println("Collected in $time ms")
}
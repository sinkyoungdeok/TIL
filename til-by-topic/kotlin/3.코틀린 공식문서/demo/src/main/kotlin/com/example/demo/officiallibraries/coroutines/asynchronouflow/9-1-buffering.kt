package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis

fun simple9dash1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple9dash1().collect{
            delay(300)
            println(it)
        }
    }
    println("Collected in $time ms")
}
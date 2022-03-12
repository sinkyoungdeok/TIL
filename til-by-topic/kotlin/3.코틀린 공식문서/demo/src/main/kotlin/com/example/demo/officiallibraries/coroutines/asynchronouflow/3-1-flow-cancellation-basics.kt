package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple3dash1(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) {
        simple3dash1().collect { println(it)}
    }
    println("Done")
}
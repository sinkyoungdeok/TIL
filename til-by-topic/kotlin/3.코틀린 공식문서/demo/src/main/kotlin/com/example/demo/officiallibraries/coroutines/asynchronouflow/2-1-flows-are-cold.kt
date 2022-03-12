package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple2dash1(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simple2dash1()
    println("Calling collect...")
    flow.collect { value -> println(value) }
    println("Calling collect again...")
    flow.collect { value -> println(value) }
}
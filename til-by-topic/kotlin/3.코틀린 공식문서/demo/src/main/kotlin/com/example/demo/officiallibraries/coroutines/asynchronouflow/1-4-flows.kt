package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple1dash4(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}


fun main() = runBlocking<Unit> {

    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    simple1dash4().collect { println(it) }
}
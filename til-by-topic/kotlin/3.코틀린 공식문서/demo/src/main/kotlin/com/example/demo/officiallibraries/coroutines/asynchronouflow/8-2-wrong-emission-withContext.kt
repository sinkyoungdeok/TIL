package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun simple8dash2(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {
        for (i in 1..3) {
            Thread.sleep(100)
            emit(i)
        }
    }
}

fun main() = runBlocking<Unit> {
    simple8dash2().collect { println(it)}
}
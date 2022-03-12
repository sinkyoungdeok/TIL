package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple8dash3(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100)
        log8dash1("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)

fun main() = runBlocking<Unit> {
    simple8dash3().collect { println(it)}
}
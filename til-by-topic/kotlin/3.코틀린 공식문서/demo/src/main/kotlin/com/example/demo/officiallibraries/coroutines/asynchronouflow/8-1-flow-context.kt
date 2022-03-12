package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun log8dash1(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun simple8dash1(): Flow<Int> = flow {
    log8dash1("Started simple flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    simple8dash1().collect { log8dash1("Collected $it")}
}
package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.*

suspend fun simple1dash3(): List<Int> {
    delay(1000)
    return listOf(1,2,3)
}

fun main() = runBlocking<Unit> {
    simple1dash3().forEach { value -> println(value)}
}
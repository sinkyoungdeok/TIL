package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun numbers5dash3(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finnaly in numbers")
    }
}

fun main() = runBlocking<Unit> {
    numbers5dash3()
        .take(2)
        .collect{println(it)}
}
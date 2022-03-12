package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        simple9dash1()
            .buffer()
            .collect {
                delay(300)
                println(it)
            }
    }
    println("Collected in $time ms")
}
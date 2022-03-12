package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun main() = runBlocking<Unit> {
    val sum = (1..5).asFlow()
        .map{it * it}
        .reduce{a,b -> a+b }
    println(sum)
}
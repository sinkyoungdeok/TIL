package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*



fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .transform {
            emit("Making request $it")
            emit(performRequest5dash1(it))
        }
        .collect { println(it) }
}
package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.map

suspend fun performRequest5dash1(request: Int): String {
    delay(1000)
    return "response $request"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow()
        .map{ performRequest5dash1(it) }
        .collect{ println(it)}
}
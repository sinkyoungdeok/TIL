package com.example.demo.officiallibraries.coroutines.asynchronouflow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() = runBlocking<Unit> {
    (1..3).asFlow().collect{println(it)}
}
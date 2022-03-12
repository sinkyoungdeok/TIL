package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis



fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow().onEach { delay(300) }
    val strs = flowOf("one","two","three").onEach { delay(400) }
    val startTime = System.currentTimeMillis()
    nums.combine(strs) {a,b -> "$a -> $b"}
        .collect {
            println("$it at ${System.currentTimeMillis() - startTime} ms from start")
        }
}
package com.example.demo.officiallibraries.coroutines.asynchronouflow


import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.system.measureTimeMillis



fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow()
    val strs = flowOf("one", "two", "three")
    nums.zip(strs) {a, b -> "$a -> $b"}
        .collect{println(it)}
}
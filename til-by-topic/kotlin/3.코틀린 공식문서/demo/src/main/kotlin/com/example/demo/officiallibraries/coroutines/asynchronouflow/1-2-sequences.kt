package com.example.demo.officiallibraries.coroutines.asynchronouflow


fun simple1dash2(): Sequence<Int> = sequence {
    for (i in 1..3) {
        Thread.sleep(100)
        yield(i)
    }
}

fun main() {
    simple1dash2().forEach { println(it) }
}
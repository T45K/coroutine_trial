package io.github.t45k.coroutine_trial.async

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    println(measureTimeMillis {
        (0..<1_000_000).map {
            async {
                println("start - $it - ${Thread.currentThread().name}")
                delay(1_000)
                println("end - $it - ${Thread.currentThread().name}")
            }
        }.awaitAll()
    })
}

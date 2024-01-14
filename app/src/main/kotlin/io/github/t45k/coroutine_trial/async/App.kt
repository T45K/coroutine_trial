package io.github.t45k.coroutine_trial.async

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.system.measureTimeMillis

suspend fun main() = coroutineScope {
    val deferred1 = async { delay(1000) }
    val deferred2 = async { delay(1000) }
    val time = measureTimeMillis {
        deferred1.await()
        deferred2.await()
    }
    println(time)
}
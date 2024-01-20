package io.github.t45k.coroutine_trial.reflection

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    val foo = Foo()
    val invoked = suspendCoroutine<Any> {
        val invoked = Foo::class.java
            .getMethod("bar", Continuation::class.java)
            .invoke(foo, it)
        println(invoked)
        invoked
    }
    println(invoked)
}

private class Foo {
    suspend fun bar(): Int = withContext(Dispatchers.Default) { 1 }
}

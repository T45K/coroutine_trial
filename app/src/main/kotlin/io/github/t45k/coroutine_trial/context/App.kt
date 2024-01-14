package io.github.t45k.coroutine_trial.context

import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.reactor.mono
import kotlinx.coroutines.withContext
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

suspend fun main() {
    mono {
        withContext(Element("withContext")) {
            showCoroutineContext()
        }
    }.awaitSingleOrNull()
}

suspend fun showCoroutineContext() {
    println(currentCoroutineContext()[Element]?.message)
}

class Element(val message: String) : AbstractCoroutineContextElement(Element) {
    companion object Key : CoroutineContext.Key<Element>
}

package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * @author NIRANJAN KHATRI
 * @since 09/03/24
 * @version 1
 */

interface CoroutineContextProvider {
    fun context(): CoroutineContext
}

class CoroutineContextProviderImpl(
    private val context: CoroutineContext
) : CoroutineContextProvider {
    override fun context(): CoroutineContext {
        return context
    }

}

fun main() {
    val parentJob = Job()
    val provider : CoroutineContextProvider = CoroutineContextProviderImpl(
        context = parentJob + Dispatchers.IO
    )

    GlobalScope.launch(context = provider.context()) {
        println("current thread 1")
    }

    val mainContextProvider = CoroutineContextProviderImpl(Dispatchers.Main)
}
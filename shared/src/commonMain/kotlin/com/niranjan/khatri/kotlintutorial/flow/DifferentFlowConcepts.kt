package com.niranjan.khatri.kotlintutorial.flow

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

// flowOf
suspend fun flowOfConcepts() {
    val simpleFlow = flowOf(1, 2, 3, 4, 5)
    simpleFlow.collect { value ->
        println(value)
        }
}

// callbackFlow
suspend fun callbackFlowConcepts() {
    val networkRequestFlow = callbackFlow {
        val callback = object: NetworkCallback {
        override fun onSuccess(result: String) {
        // Send the result to the flow
            this@callbackFlow.trySend(result).isSuccess // trySend is regular function and it is asynchronous - you immediately get the result
        }
        override fun onFailure(error: Throwable) {
            // Handle failure or send an error signal to the flow
            close(error)
            }
        }
        makeNetworkRequest(callback)
    // Close the channel when the collector cancels
        awaitClose {
        // Cleanup, if needed
        }
    }
    // Launch a coroutine to collect the data
    val job = coroutineScope {
        networkRequestFlow.collect { result ->
        println(result)
        }
    }
}

fun makeNetworkRequest(callback: NetworkCallback) {

}

interface NetworkCallback{
    fun onSuccess(result: String)
    fun onFailure(error: Throwable)
}


// channelFlow
suspend fun channelFlowConcepts() {
    val channelFlowExample = channelFlow {
        // Emit values imperatively
        send(1)
        send(2)
        send(3)
// Close the channel when the collector cancels
        awaitClose {
        // Cleanup, if needed
        }
        }
// Launch a coroutine to collect the data
    val job = coroutineScope {
        channelFlowExample.collect { value ->
        println(value)
        }
        }
}

// Custom Flow Concepts
fun customFlow() = flow {
    for (i in 1..5) {
    delay(500) // Simulating some asynchronous work
    emit(i)
    }
}
fun customFollowCollect() = runBlocking {
    customFlow().collect { value ->
    println(value)
    }
}
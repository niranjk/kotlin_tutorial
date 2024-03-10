package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

/**
 * Coroutine is a simple way to write asynchronous code in a sequential way
 * It is lightweight thread that doesn't require context switching
 * Coroutine can be suspended and resumed without blocking the executing thread.
 */

fun main() {
    println("Start of the main function")
    // Launch a coroutine to fetch data asynchronously
    GlobalScope.launch {
        val result = fetchData()
        println("Data received: $result")
        }
    // Do some other work in the main function
    println("Doing other work in the main function")
    // Adding a delay to give the coroutine time to complete
    runBlocking {
        delay(2000)
        }
    println("End of the main function")

    GlobalScope.launch {
        val response = async {
            computation()
        }
        println("Server response: ${response.await()}")
    }

    println("Start of the main function")
}

suspend fun computation(): String{
    delay(2000L)
    return "Success"
}
suspend fun fetchData(): String {
    delay(1000) // Simulating network delay
    return "Data from the remote server"
}

/**
 * Continuation
 * */
fun backgroundTask(param: Int, callback: Continuation<Int>) {
    // Simulating a long-running operation
    GlobalScope.launch {
        delay(1000)
        // Resuming the coroutine with a result
        callback.resume(param * 2)
        }
}


/***
 * `launch` and `join` example
 */
fun launchNJoinExample(){
    println("Start of the main function")
// Using launch to start a coroutine (fire-and-forget)
    val job = GlobalScope.launch {
        println("Coroutine is doing some work")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other main function code
    println("Main function continues")
// Using join to wait for the completion of the launched coroutine
    runBlocking {
        job.join()
        println("End of the main function")
        }
}


/***
 * `async` and `await` example
 */
fun asyncNAwaitExample() =
    runBlocking {
        println("Start of the main function")
// Using async to start a coroutine that computes a result
        val deferredResult: Deferred<String> = async {
        println("Async coroutine is computing a result")
        delay(1000)
        "Result from async coroutine"
        }
// Other main function code
        println("Main function continues")
// Using await to retrieve the result from the async coroutine
        val result = deferredResult.await()
        println("Received result: $result")
        println("End of the main function")
    }


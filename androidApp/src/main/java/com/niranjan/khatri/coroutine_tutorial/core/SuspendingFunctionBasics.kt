package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * @author NIRANJAN KHATRI
 * @since 06/03/24
 * @version 1
 */
fun main() = runBlocking { val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    launch { // Coroutine for network request
        val result = fetchDataFromNetwork()
        println("Network result: $result")
    }
    launch {// Coroutine for CPU-bound task
        withContext(Dispatchers.Default) {
            val processedData = processData(fetchDataFromLocal())
            println("Processed data: $processedData")
        }
    }
    println("Main thread continues....")
    delay(1000) // Simulate some work on the main thread
}
suspend fun fetchDataFromNetwork(): String {
    delay(2000) // simulate network call
    return "Network data"
}
fun fetchDataFromLocal(): String {
    return "Local data"
}
suspend fun processData(data: String): String {
    delay(1000) // simulate CPU-bound processing
    return "Processed: $data"
}

/*
fun nonSuspendFunction() {
    // Code that does not involve any suspension points
    println("Non-suspending function executing...")
    Thread.sleep(1000) // Simulate some blocking operation
    println("...done.")
}

 */

suspend fun suspendFunction() {
    // Code that might involve suspension points
    println("Suspending function executing...")
    delay(1000) // Suspends the coroutine for 1 second
    println("...done.")
}
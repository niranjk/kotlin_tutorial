package com.niranjan.khatri.coroutine_tutorial.basics

import kotlinx.coroutines.runBlocking


/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */

/**
 * Coroutine approach to communicate work completion
 * in asynchronous programming
 */
fun main() {
    runBlocking {
        val result = fetchCoroutineData()
        println("Got the result: $result")
        // You can do more stuff with the results....
    }
}

suspend fun fetchCoroutineData() : String{
    // Simulating asynchronous operation
    kotlinx.coroutines.delay(2000)
   return "Fetched Data"
}


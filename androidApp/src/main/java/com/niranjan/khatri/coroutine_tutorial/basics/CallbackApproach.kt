package com.niranjan.khatri.coroutine_tutorial.basics


/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */

/**
 * Traditional Callback approach to communicate work completion
 * in asynchronous programming
 */
fun main() {
    fetchData{ result ->
        println("Got the result: $result")
    }
}

fun fetchData(callback: (String) -> Unit){
    // Simulating asynchronous operation
    Thread.sleep(2000)
    callback("Fetched Data")
}


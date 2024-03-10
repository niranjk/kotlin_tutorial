package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable.join
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */

/***
 * Routine
 * fun main() {
 *     // Main Routine
 *     val result = greet("World")
 *     println(result)
 *     // More code..
 *
 * fun greet(name: String) : String{
 *     // Subroutine
 *     return "Hello, $name"
 * }
 * }
 */

fun fetchData(url: String) = runBlocking {
    val scope = CoroutineScope(Dispatchers.IO) // Specify a dispatcher
    val job1 = scope.launch {
        // Download data from url
    }
    val job2 = scope.launch {
        // Do something else while data is being downloaded
    }
    // Wait for both coroutines to finish
    job1.join()
    job2.join()
    // Do something with the downloaded data
}

fun coroutineDependentJobConcept() = runBlocking {
    val job1 = launch(start = CoroutineStart.LAZY) {
        delay(1000) // Simulate a delay
        println("Pong")
    }

    val job2 = launch {
        println("Ping")
        joinAll(job1) // Wait for job1 to finish
        println("Ping")
    }
    // Main thread continues execution
}

fun jobHierarchyUsingParentChildRelationship() = runBlocking {
    val parentJob = launch {
        // Parent coroutine
        val childJob1 = launch {
            // Child coroutine
            println("Child coroutine 1")
        }

        childJob1.join() // Wait for the child1 to finish
        println("Parent coroutine")
    }
    val childJob2 = launch(context = parentJob) {
        // Child coroutine
        println("Child coroutine 2")
    }
    // Observe parent job's children
    // Observe parent job's children
    println("Children of parent job: ${parentJob.children.toList().size}")

}

fun updateUI(data: String) {
    runBlocking {
        launch {
            val processedData = processDataNew(data) // Background operation
            withContext(Dispatchers.Main) {
                // Update UI elements on the main thread
                // textView.text = processedData
            }
        }
    }
}
fun processDataNew(data: String) = "Data From Background"





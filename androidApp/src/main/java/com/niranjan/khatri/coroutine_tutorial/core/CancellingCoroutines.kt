package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException


/**
 * @author NIRANJAN KHATRI
 * @since 11/03/24
 * @version 1
 */

/*

// CANCELLING COROUTINES
fun main() = runBlocking{
    val time = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var next = time
        var i = 0
        while (i < 10) {
            if (System.currentTimeMillis() >= next) {
                println("Work: $i")
                i++
                next += 500L
            }
        }
    }
    delay(1000)
    println("Cancelling coroutine")
    job.cancel()
    println("quit!")
}

 */

/*
// CANCELLATIONEXCEPTION
fun main() = runBlocking {
    val customExceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught original $exception")
    }
    val parentJob = GlobalScope.launch(customExceptionHandler) {
        val childJob = launch {
            throw IOException()
        }

        try {
            childJob.join()
        } catch (e: CancellationException) {
            println("Re Throw CancellationException with the original cause: ${e.cause}")
            throw e
        }
    }
    parentJob.join()
}

 */

/*
// JOIN
fun main() = runBlocking {
    val launched = launch {
        delay(1000L) // Simulate some work
        println("Coroutine launched is finished.")
    }
// Waits for 'launched' to complete before continuing
    launched.join() // May throw CancellationException if 'launched' was cancelled
    println("Main coroutine finished.")
}


 */

/*
// CANCELANDJOIN
fun main() = runBlocking {
    val launched = launch {
        delay(2000L) // Simulate some work
        println("Coroutine launched is finished.")
    }
// Attempt to cancel and then wait for 'launched'
    try {
        launched.cancelAndJoin()
        println("Coroutine launched was cancelled and finished.")
    } catch (e: CancellationException) {
        println("Coroutine launched was cancelled.")
    } finally {
        // Optional cleanup code here (e.g., closing resources)
    }
    println("Main coroutine finished.")
}

 */

/*
// CANCELCHILDREN
fun main() = runBlocking {
    val parentJob = launch {
        val child1 = launch {
            delay(1000L)
            println("Child coroutine 1 finished.")
        }
        // handle exception
        child1.invokeOnCompletion { exception ->
            println("Child One: ${exception?.message}")
        }


        val child2 = launch {
            delay(2000L)
            println("Child coroutine 2 finished.")
        }
        // handle exception
        child2.invokeOnCompletion { exception ->
            println("Child Two: ${exception?.message}")
        }
    }
    delay(1000L)
    println("Call cancelChildren() on parentJob")
    parentJob.cancelChildren()
    println("ParentJob isActive: ${parentJob.isActive}")
}

 */

fun main() = runBlocking {
    withTimeout(2000L) {
        repeat(1000) { i ->
            println("$i. KNOCKING DOOR [TIK.TOCK.TICK.TOCK]...")
            delay(500L)
        }
    }
}

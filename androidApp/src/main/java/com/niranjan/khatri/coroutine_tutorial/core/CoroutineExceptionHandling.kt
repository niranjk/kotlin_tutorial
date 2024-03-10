package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import java.io.IOException
import java.lang.IllegalStateException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * @author NIRANJAN KHATRI
 * @since 10/03/24
 * @version 1
 */

/*
  runBlocking {
      downloadFile("https://notarealwebsite.com/file.txt") // This might fail!
      // Code continues even if download fails (exception not handled)
  }

  fun downloadFile(url: String) = runBlocking {
    launch {
        val data = URL(url).readBytes() // Simulate download
        println("Downloaded data: $data")
    }
}
*/

/*
runBlocking {
        val download = downloadFileSafe("https://notarealwebsite.com/file.txt")
        try {
            val data = download.await() // Might throw exception here!
            println("Downloaded data: $data")
        } catch (e: Exception) {
            println("Download failed: $e") // Handle the exception
        }
    }

   fun downloadFileSafe(url: String) = runBlocking {
    GlobalScope.async {
        val data = URL(url).readBytes() // Simulate download
        String(data) // Convert to String (might throw exception)
    }
}
 */

/*
val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Global exception handler: $throwable")
    }
    runBlocking { // Parent Job
        val parentJob = GlobalScope.launch(exceptionHandler) {
            // Launch multiple child coroutines (some might throw exceptions)
            // Child Job 1
            launch {
                try {
                    delay(Long.MAX_VALUE)
                } catch (e: Exception) {
                    println("${e.javaClass.simpleName} in Child Job 1")
                } finally {
                    throw ArithmeticException()
                }
            }
            // Child Job 2
            launch {
                delay(100)
                throw IllegalStateException()
            }
            // Delaying the parentJob
            delay(Long.MAX_VALUE)
        }
        // Wait until parentJob completes
        parentJob.join()
    }
 */

/*
runBlocking {
        try {
            val data = getDataAsync()
            println("Data received: $data")
        } catch (e: Exception) {
            println("Caught ${e.javaClass.simpleName}")
        }
    }
// Callback Wrapping using Coroutine
suspend fun getDataAsync(): String {
    return suspendCancellableCoroutine { continuation ->
        getTickTokData(object : AsyncCallback {
            override fun onSuccess(result: String) {
                continuation.resume(result)
            }
            override fun onError(e: Exception) {
                continuation.resumeWithException(e)
            }
        })
    }
}
// Method to simulate a long running task
fun getTickTokData(asyncCallback: AsyncCallback) {
    val triggerError = false

    try {
        Thread.sleep(2000)
        if (triggerError) {
            throw IOException()
        } else {
            // Send success
            asyncCallback.onSuccess("[Tick.Tok.Tick.Tock..]")
        }
    } catch (e: Exception) {
        // send error
        asyncCallback.onError(e)
    }
}
// Callback
interface AsyncCallback {
    fun onSuccess(result: String)
    fun onError(e: Exception)
}
 */
fun main() = runBlocking{
// SupervisorJob..
    val supervisor = SupervisorJob()
    with(CoroutineScope(coroutineContext + supervisor)) {
        val firstJob = launch {
            println("First Job throwing an exception")
            throw IllegalStateException()
        }
        val secondJob = launch {
            println("First job is cancelled: ${firstJob.isCancelled}")
            try {
                delay(5000)
            } catch (e: CancellationException) {
                println("Second job cancelled because supervisor got cancelled.")
            }
        }
        firstJob.join()
        println("Second child is active: ${secondJob.isActive}")
        supervisor.cancel()
        secondJob.join()
    }
}






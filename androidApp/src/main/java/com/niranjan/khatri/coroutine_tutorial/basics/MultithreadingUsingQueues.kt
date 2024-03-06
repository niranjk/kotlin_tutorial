package com.niranjan.khatri.coroutine_tutorial.basics

/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */

import kotlinx.coroutines.*
import java.util.concurrent.LinkedBlockingQueue
// Define a custom message class
data class MyMessage(val content: String)
// Create a blocking queue
val messageQueue = LinkedBlockingQueue<MyMessage>()
fun main() { runBlocking {
        // Launch a producer coroutine
        launch {
            repeat(10) {
                val message = MyMessage("Message $it")
                println("Producer: Adding message $message")
                messageQueue.put(message) // Blocking call, waits if full
                delay(1000) // Simulate work
            }
        }
        // Launch a consumer coroutine
        launch {
            repeat(10) {
                val message = messageQueue.take() // Blocking call, waits if empty
                println("Consumer: Consuming message - ${message.content}")
                delay(2000) // Simulate processing
            }
        }
    }
}


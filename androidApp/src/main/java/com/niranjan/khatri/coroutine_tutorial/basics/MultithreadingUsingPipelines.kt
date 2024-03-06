package com.niranjan.khatri.coroutine_tutorial.basics

/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

// Define a custom message class
data class Message(val content: String)

fun main(){
    runBlocking {
        // Create a channel with a buffer capacity (optional)
        val pipeline = Channel<Message>(5) // Buffer capacity of 5 messages

        // Launch a producer coroutine
        launch {
            repeat(10) {
                val message = Message("Message $it")
                println("Producer: Sending message $message")
                pipeline.send(message) // Suspends if buffer is full (backpressure)
                delay(500) // Simulate work
            }
        }
        // Launch a consumer coroutine
        launch {
            repeat(10) {
                val message = pipeline.receive() // Suspends if buffer is empty
                println("Consumer: Processing message - ${message.content}")
                delay(1000) // Simulate processing
            }
        }
    }
}

package com.niranjan.khatri.coroutine_tutorial.advanced

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

/**
 * @author NIRANJAN KHATRI
 * @since 13/03/24
 * @version 1
 */
/*
fun main() = runBlocking{
    numbersFlow(2,10).collect{
        println("collect: $it")
    }
}

fun numbersFlow(from: Int, to: Int): Flow<Int> = flow {
    for (i in from..to) {
        emit(i) // Emit each number in the range
        delay(100) // Simulate some delay
    }
}

 */

/*
// Flow with Backpressure
fun main() = runBlocking{
    receiveMessages(listOf("hi", "how", "you", "doing?")).collect{
        println(it)
    }
}

fun receiveMessages(messages: List<String>): Flow<String> = flow {
    messages.forEach { message ->
        emit(message)
        delay(1000) // Simulate slow network delay
    }
}

 */

/*
// Collecting and Transforming Values in Flow
fun main() = runBlocking{
    processNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)).collect{
        println("Processed number: $it") // Print for demonstration
    }
}
fun processNumbers(numbers: List<Int>): Flow<Int> = flow {
    numbers.asFlow() // Convert list to Flow
        .map { it * 3 } // Triple each number
        .filter { it % 2 != 0 } // Filter out even numbers
        .collect { number ->
            emit(number) // Emit the transformed value
            delay(1000) // Simulate processing each number
        }
}

 */

/*
// Combining multiple flow using zip
fun main() = runBlocking{
    combineSongInfo(
        songTitles = flowOf("Hello", "American Idiot"),
        artistNames = flowOf("Edle", "GreenDay")
    ).collect{
        println(it)
    }
}

fun combineSongInfo(songTitles: Flow<String>, artistNames: Flow<String>): Flow<String> =
    flow {
        combine(songTitles, artistNames) { title, artist ->
            "$title - $artist" // Combine title and artist
        }
            .collect { combinedInfo ->
                emit(combinedInfo) // Emit the combined string
            }
    }

 */

/*
// Switching Context in Flow
fun main() = runBlocking{
    val message = "This is a message to be processed!"
    processMessage(message).collect{
        println(it)
    }
}
fun processMessage(message: String): Flow<String> = flow {
    // Flow of the message (can be replaced with any Flow creation method)
    flowOf(message)
        // Simulate slow processing on IO dispatcher (pretend it's network fetching)
        .flowOn(Dispatchers.IO)
        // Convert to uppercase on Default dispatcher
        .map { it.uppercase() }
        .flowOn(Dispatchers.Default)  // Simulate additional processing
        // Collect and print on the collection context (likely the main thread)
        .collect { processedMessage ->
            println(processedMessage)  // Print the result
        }
}

 */

// Catching Exceptions using flow
fun main() = runBlocking{
    flowOf("Catch MEEE if you can")
        .map { it.split(" ") }
        .map { it[1] }
        .catch { it.printStackTrace() }
        .flowOn(Dispatchers.Default)
        .collect { println(it) }
}




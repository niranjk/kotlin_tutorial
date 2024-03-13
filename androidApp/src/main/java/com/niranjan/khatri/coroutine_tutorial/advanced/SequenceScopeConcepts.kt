package com.niranjan.khatri.coroutine_tutorial.advanced

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author NIRANJAN KHATRI
 * @since 12/03/24
 * @version 1
 */

fun main() = runBlocking {
    // Sequence generating squares of numbers
    val squares: Sequence<Int> = sequence {
        var number = 1
        while (true) {
            yield(number * number) // Suspend and yield the square
            number++
        }
    }
// Take the first 5 squares using a coroutine
    launch {
        squares.take(5).forEach { println(it) } // Print the first 5 squares
    }
    delay(1000L) // Wait for some time (demonstrating lazy evaluation)
}
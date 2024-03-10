package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors


/**
 * @author NIRANJAN KHATRI
 * @since 10/03/24
 * @version 1
 */
fun main() {
    val executorDispatcher = Executors
        .newFixedThreadPool(4)
        .asCoroutineDispatcher()

    val number = 14

    GlobalScope.launch(context = executorDispatcher) {
        // Simulate CPU-bound calculations
        repeat(1000) {
            Math.sqrt(number.toDouble())
        }
        println("Calculations finished for: $number")
    }

    paintHouse("Red")

    val sandingJob1 = sandDoor("Left")
    val sandingJob2 = sandDoor("Right")
    paintDoor("Left")
    paintDoor("Right")
    // Wait for sanding and painting to finish
    runBlocking {
        sandingJob1.join()
        sandingJob2.join()
    }
}


fun preparePaint(color: String) = runBlocking {
    launch(Dispatchers.IO) { // Network call (I/O bound)
        println("Mixing paint ($color) on a separate thread")
        delay(1000L) // Simulate network call
    }
}
fun paintHouse(color: String) = runBlocking {
    launch(Dispatchers.Default) { // CPU bound
        val paint = async { preparePaint(color) }.await() // Wait for paint (I/O)
        println("Painting house with $color (on default thread)")
        delay(2000L) // Simulate painting
    }
}

fun paintDoor(side: String) = runBlocking {
    launch(Dispatchers.IO) { // Simulate waiting for paint
        delay(1000L) // Simulate waiting for paint (I/O bound)
        println("Painting $side of the door (on separate thread)")
    }
}

fun sandDoor(side: String) = runBlocking {
    launch(Dispatchers.Default) {
        println("Sanding $side of the door (on default thread)")
        delay(500L) // Simulate work
    }
}

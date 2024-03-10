package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @author NIRANJAN KHATRI
 * @since 08/03/24
 * @version 1
 */
class CoroutineContextBasics {
    val job = Job() // this tool defines the car's lifecycle (can be stopped)
    fun driveCar(distance: Int) = runBlocking {
        launch(job){// launch a car with the job
            println("Driving for $distance meteres... ")
            delay(distance* 100L) // Simulate driving time
            println("Car arrived!")
        }
    }
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        println("Uh oh! Car encountered an error: $throwable")
    }
    fun controlSteering(direction: String) = runBlocking {
        launch(Dispatchers.Default + exceptionHandler) {
            println("Steering car $direction...")
            // Simulate a potential error (e.g., invalid direction)
            if (direction == "Fly") throw IllegalArgumentException("Cars can't fly!")
            println("Steering successful!")
        }
    }
}
fun main() {
    // Start driving !! (This can be cancelled later)
    CoroutineContextBasics().driveCar(1000)
    // Start controlling (with potential for errors)
    CoroutineContextBasics().controlSteering("Left")
}

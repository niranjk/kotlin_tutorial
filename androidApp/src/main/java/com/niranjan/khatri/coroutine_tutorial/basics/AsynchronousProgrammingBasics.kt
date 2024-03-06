package com.niranjan.khatri.coroutine_tutorial.basics

import kotlinx.coroutines.* // We'll use coroutines for asynchronous work

/**
 * @author NIRANJAN KHATRI
 * @since 27/02/24
 * @version 1
 */


/**
 * Synchronous Programming: The Old way
 * Everything happening in sequence
 */
fun orderFoodSynchronously() {
    println("Ordering pasta...")
    val pasta = cookingOrMaking("Pasta") // This might take a long time
    println("Pasta is ready!")
    println("Ordering salad...")
    val salad = cookingOrMaking("Salad")
    println("Salad is ready!")
    println("Enjoying my meal!")
}

/**
 * Asynchronous Way: We use Coroutines for this
 */
fun orderFoodAsynchronously() = runBlocking {
    println("Ordering pasta and salad...")
    val pastaJob = launch { cookingOrMaking("Pasta") } // Start cooking pasta, will finish in the background
    val saladJob = launch { cookingOrMaking("Salad") }  // Start making salad in parallel
    // We can do other things here while we wait
    println("Salad is ready!") // Might be ready before pasta
    val salad = saladJob.join() // Wait for salad to finish
    // join is suitable when we don't need to return a value and just ensure the coroutine finishes
    println("Pasta is ready!")
    val pasta = pastaJob.join() // Wait for pasta
    println("Enjoying my meal!")
}
fun cookingOrMaking(item: String) = println("Cooking or Making $item")


fun main() { uploadFile("File://filepathname/image.png") }
fun uploadFile(filePath: String) = runBlocking { val uploadJob = launch {
        // Simulate uploading the file
        delay(5000) // Replace with your actual upload logic
        println("File uploaded successfully!")
    }
    showProgressBar(this, uploadJob)
    // Handle completion (success or error)
    if (uploadJob.isCompleted) { println("Upload finished.") } else { println("Upload failed.") }
}
suspend fun showProgressBar(coroutineScope: CoroutineScope, uploadJob: Job){
    // Show a progress bar or loader while uploading and provides a feedback to user
    var progress = 0
    while (coroutineScope.isActive && uploadJob.isActive) {
        delay(1000) // Update progress every second
        progress += 20
        println("Upload progress: $progress%")
    }
}



package com.niranjan.khatri.coroutine_tutorial.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/****
 * GlobalScope
 * CoroutineScope
 * LifecycleScope -> Android
 * ViewModelScope -> Android
 */

fun main() {
    // GLOBALSCOPE LAUNCH WITH DISPATCHER.IO
    GlobalScope.launch(Dispatchers.IO) {
        println("Coroutine running in the IO dispatcher")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other main function code
    println("Main function continues")
// Adding a delay to give the coroutine time to complete
    runBlocking {
        delay(2000)
        }
    // GLOBALSCOPE LAUNCH
    GlobalScope.launch {
        println("Coroutine running in the Default dispatcher")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other main function code
    println("Main function continues")
// Adding a delay to give the coroutine time to complete
    runBlocking {
        delay(2000)
        }

    runBlocking {
        CoroutineScope(Dispatchers.IO).launch {
        println("Coroutine running in a custom IO dispatcher")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other main function code
        println("Main function continues")
// Adding a delay to give the coroutine time to complete
        delay(2000)
        }
}

/*
Need Library : AndroidX.Lifecycle & AndroidX.ViewModel : Android Dependent

suspend fun exampleFunction() {
    lifecycleScope.launch(Dispatchers.IO) {
        println("Coroutine running in the IO dispatcher within lifecycleScope")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other function code
    println("Function continues")
// Adding a delay to give the coroutine time to complete
    delay(2000)
}

suspend fun exampleLifecycleScopeFunction() {
    lifecycleScope.launch {
        println("Coroutine running in the Default dispatcher within lifecycleScope")
        delay(1000)
        println("Coroutine completed its work")
        }
// Other function code
    println("Function continues")
// Adding a delay to give the coroutine time to complete
    delay(2000)
}

class MyViewModel: ViewModel() {
    fun exampleFunction() {
        viewModelScope.launch(Dispatchers.IO) {
            println("Coroutine running in the IO dispatcher within viewModelScope")
            delay(1000)
            println("Coroutine completed its work")
        }
// Other function code
        println("Function continues")
// Adding a delay to give the coroutine time to complete
        delay(2000)
    }
}

 */

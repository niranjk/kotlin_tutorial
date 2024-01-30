package com.niranjan.khatri.kotlintutorial.concepts

// Lazy Initialization
/**
 * Suited for deferring computation until access
 * Opt for by lazy { }** when you prioritize thread safety, a single initializer, and the ability to use a Lazy instance for multiple properties.
 */
public class LazyHello {
    val myLazyHelloString : String by lazy { "Hello" }
}

// Late Initialization
/**
 * It is go-to option when you need to postpone property initialization until a specific point in your code
 * Choose lateinit var when you need flexibility in initialization locations and direct access to the backing field.
 */
public class MyLateInitialization {
    lateinit var subject : String
    fun setUp() { subject = "Late Initialized Value"}

    fun checkLateInitialization(){
        if (this::subject.isInitialized){
            // Check the initialization state of lateinit variable directly
        }
    }
}
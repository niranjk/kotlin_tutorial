package com.niranjan.khatri.kotlintutorial.concepts

inline fun <reified T> printClassName(obj: T) {
    val className = T::class.simpleName
    println("The class name is: $className")
}
fun main() {
    val stringValue = "Hello, Kotlin!"
    val intValue = 42
    val listValue = listOf(1, 2, 3)
    printClassName(stringValue) // Outputs: The class name is: String
    printClassName(intValue) // Outputs: The class name is: Int
    printClassName(listValue) // Outputs: The class name is: List
}
package com.niranjan.khatri.kotlintutorial.basics

/**
 * @author NIRANJAN KHATRI
 * @since 26/02/24
 * @version 1
 */

/**
 * [printMyName] function has
 * @param name of type [String]
 */
fun printMyName(name: String){
    println("My Name is: $name")
}

// named parameters
fun addTwoNumbers(num1: Int, num2: Int = 1): String{
    return "Result = ${num1+num2}"
}

// Overloading Functions
fun overloadingFun(value: Int) = println("Overloading $value")
fun overloadingFun(value: String) = println("Overlaoding $value")

/**
 *   // Using function as a variables
 *     var myFunction = ::div
 *     // now use it
 *     val result = myFunction(30, 5)
 *     println("Result = $result")
 */
fun div(numerator: Int, denominator: Int): Int = numerator/denominator


fun main() {
    // No Return Function
    noReturnFunction()
}

fun noReturnFunction(): Nothing {
    while (true){
        println("Printing in a Loop!")
    }
}









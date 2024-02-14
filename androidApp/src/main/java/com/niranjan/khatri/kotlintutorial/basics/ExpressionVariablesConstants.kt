package com.niranjan.khatri.kotlintutorial.basics



// This is a single line comment
// This is a multi line comment

/*
 * This is a comment which can span
 * over
 * ..many
 * /**
    You can also have another internal comment here..
 */
 * many lines..
 */

/**
 *  // Arithmetic operations
 *     val addNumbers = 1+2
 *     val subNumbers = 10-2
 *     val multiNumbers = 14*12
 *     val divNumbers = 14/7
 *     println("Add: $addNumbers")
 *     println("Subtract: $subNumbers")
 *     println("Multiply: $multiNumbers")
 *     println("Divide: $divNumbers")
 *
 */

/*
// Integer and Decimal Numbers
    val intNumber = 14
    val decimalNumber = 14.0

    val intResult = intNumber /2
    val decimalResult = decimalNumber/3.0

    println("Integer: $intResult")
    println("Decimal: $decimalResult")
 */

/*
    // Remainder Operation
    val intNumber = 24
    val decimalNumber = 24.0

    val intRemainderResult = intNumber % 10
    val decimalRemainderResult = decimalNumber % 10.0

    println("Integer Remainder: $intRemainderResult")
    println("Decimal Remainder: $decimalRemainderResult")
 */

/*
// Shift Operations
    val shiftLeftResult = 1 shl 6
    val shiftRightResult = 14 shr 1
    println("Shift Operation Left $shiftLeftResult")
    println("Shift Operation Right $shiftRightResult")
 */

import java.lang.Math.PI
import java.lang.Math.cos
import java.lang.Math.max
import java.lang.Math.min
import java.lang.Math.sin
import java.lang.Math.sqrt

/*
// Math function
    val sinResult = sin(14 * PI / 180)
    val cosResult = cos(125 * PI / 180)
    val sqrtResult = sqrt(3.0)
    val maxResult = max(5, 15)
    val minResult = min(-5, -15)

    println("sin : $sinResult")
    println("cos : $cosResult")
    println("sqrt : $sqrtResult")
    println("max : $maxResult")
    println("min : $minResult")
 */

/*
// Increment and Decrement
    var counter: Int = 0
    counter += 3
    // counter = 3
    println(counter)
    counter -= 2
    // counter = 1
    println(counter)
 */

fun main() {
    // Variables and Constants
    var variableNumber : Int = 14
    variableNumber = 0 // variables can be reassigned
    variableNumber = 1_000
    println(variableNumber)

    val pi: Double = 3.14159
    val number : Int = 7
    // number = 2 // val cannot be reassigned
}


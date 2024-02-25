package com.niranjan.khatri.kotlintutorial.advanced

/**
 * @author NIRANJAN KHATRI
 * @since 24/02/24
 * @version 1
 */

/**
 * Demonstrates different types of ranges in Kotlin: closed, half-open, and decreasing.
 * // Ranges
 *     println("Closed Ranges")
 *     val rangesTypeClosed = 0..3
 *     rangesTypeClosed.forEach { index -> print("$index ") }
 *     println("\nHalf Open Ranges")
 *     val rangesTypesHalfOpen = 0 until 3
 *     rangesTypesHalfOpen.forEach { index -> print("$index ") }
 *     println("\nDecreasing Ranges")
 *     val rangesTypeDecreasing = 3 downTo 0
 *     rangesTypeDecreasing.forEach { index -> print("$index ") }
 */

/**
 *  Calculates the sum of consecutive numbers from 1 to a given value.
 *  This program demonstrates the use of a `for` loop to iterate
 *  through a range of numbers and increment a running total.
 *   val index = 3
 *     var result = 0
 *     for (i in 1..index){
 *         result+= i
 *     }
 *     println("Result: $result")
 */

/**
 * Prints consecutive numbers from 0 (inclusive) to a given index (exclusive).
 * This program demonstrates the use of the `repeat` function to execute a block of code
 * a specified number of times. Each iteration prints the current loop counter (`it`).
 * val index = 3
 *     repeat(index){
 *         println(it)
 *     }
 */

/**
 * Prints odd numbers from 1 to 5 (inclusive) using a step of 2.
 * This program demonstrates the use of a `for` loop with a `step` parameter to iterate
 * through a range with a specific increment. It only prints odd numbers by checking the
 * remainder after dividing the counter (`i`) by 2.
 *     for (i in 1..5 step 2) println(i)
 *
 */

/**
 * // Loop through numbers from 1 to 10
 *     for (i in 1..10) {
 *         // Skip odd numbers using `continue`
 *         if (i % 2 != 0) continue
 *         // Print only even numbers
 *         println(i)
 *     }
 */

fun main() {
    val (x, y) = Pair(1,2)
    when {
        x == 0 && y == 0 -> println("Origin")
        y == 0 -> println("On the x-axis at x = $x")
        x == 0 -> println("On the y-axis at y = $y")
        else -> println("In 2D Plot at x = $x, y = $y")
    }
}
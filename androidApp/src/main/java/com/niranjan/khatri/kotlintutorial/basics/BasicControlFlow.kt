package com.niranjan.khatri.kotlintutorial.basics

/**
 * BOOLEAN OPERATORS
 * Demonstrates the equality operator (==),
 * the not equal operator (!=),
 * and the logical NOT operator (!) in Kotlin.
 *
 * // Equality Operator
 *     val isOneEqualTwo = (100 == 50) // always returns false
 *     val isOneNotEqualTwo = (100 != 50) // always returns true
 *     // Not - Operator
 *     val isOneNotEqualTwo2 = !(100 == 50) // always returns true
 *     println(isOneEqualTwo)
 *     println(isOneNotEqualTwo)
 *     println(isOneNotEqualTwo2)
 */

/**
 * Demonstrates the behavior of the logical AND (&&) and OR (||) operators in Kotlin.
 *
 * This code uses various comparisons to illustrate the truth tables of the operators.
 * Each variable assignment showcases a specific combination of true/false values and the resulting output.
 *  // Boolean And &&
 *     val booleanAnd1 = (11 == 22) && (23 == 33) // false && false results to false
 *     val booleanAnd2 = (11 == 22) && (23 > 33) // false && true results to false
 *     val booleanAnd3 = (11 < 22) && (23 < 33) // true && true results to true
 *     val booleanAnd4 = (11 < 22) && (23 == 33) // true && false results to false
 *     // Boolean OR ||
 *     val booleanOr1 = (11 == 22) || (23 == 33) // false || false results to false
 *     val booleanOr2 = (11 == 22) || (23 > 33) // false || true results to true
 *     val booleanOr3 = (11 < 22) || (23 < 33) // true || true results to true
 *     val booleanOr4 = (11 < 22) || (23 == 33) // true || false results to true
 */

/**
 * Demonstrates string comparison operations in Kotlin.
 * This code explores two common ways to compare strings:
 * 1. **Equality check:** Uses the `==` operator to determine if two strings contain the same characters in the same order.
 * 2. **Alphabetical order check:** Uses the `>` operator to compare the lexicographical order of two strings.
 * // Comparing Strings
 *     val animalsEqualityCheck = "cat" == "mouse" // equality check
 *     val animalsOrderCheck = "cat" < "mouse" // checks if string alphabetical order
 *     println(animalsEqualityCheck)
 *     println(animalsOrderCheck)
 */

/**
 * Demonstrates conditional statements (if-else-if ladder) with multiple conditions for grading in Kotlin.
 *
 * This code simulates a simple grading system based on a given marks value.
 * It showcases how to use multiple if-else-if statements to evaluate different conditions and assign appropriate outcomes.
 *
 * Key points:
 * - Uses `if` statements to check for specific marks ranges and assign corresponding results.
 * - Employs the `else` clause to handle invalid input (marks less than or equal to 0).
 * - Prints the final result to the console using `println`.
 *
 * val marks = 90
 *     val result = if ((marks > 0) && (marks < 30)) {
 *         "Fail"
 *     } else if ((marks > 30) && (marks < 50)) {
 *         "Just Pass"
 *     } else if ((marks > 50) && (marks < 80)) {
 *         "Average Pass"
 *     } else if ((marks >= 80)) {
 *         "Pass with Distinction"
 *     } else {
 *         "Invalid Number"
 *     }
 *     println(result)
 */

/**
 * Demonstrates a `while` loop in Kotlin that doubles a variable until it reaches a certain value.
 *
 * This code initializes an `index` variable with the value 1. It then enters a `while` loop that continues as long as `index` is less than 100.
 * Inside the loop, the `index` is doubled using the multiplication operator (`*`). The new value of `index` is then printed to the console.
 * The loop continues until the condition `index < 100` becomes false, indicating that `index` has reached or exceeded 100.
 *
 * var index = 1
 *     while (index < 100){
 *         index = index * 2
 *         println(index)
 *     }
 */

/**
 * Demonstrates a `do-while` loop in Kotlin that doubles a variable until it reaches a certain value.
 *
 * This code initializes an `index` variable with the value 1. It then enters a `do-while` loop that executes the body at least once before checking the condition.
 * Inside the loop, the `index` is doubled using the multiplication operator (`*`). The new value of `index` is then printed to the console.
 * The loop continues as long as `index` is less than 100. This means the loop body will execute even if the initial value of `index` is already greater than or equal to 100.
 * var index = 1
 *     do {
 *         index *= 2
 *         println(index)
 *     }while (index < 100)
 */

/**
 * Demonstrates a `while` loop in Kotlin that doubles a variable until it reaches a specific limit, using the `break` statement for early termination.
 * This code initializes an `index` variable with the value 1. It enters a `while` loop that continues as long as `index` is less than 200.
 * Inside the loop:
 * - The `index` is doubled using the multiplication operator (`*`).
 * - An `if` statement checks if `index` is greater than or equal to 500.
 *     - If true, the `break` statement is executed, terminating the loop immediately.
 * - If the `if` condition is false, the current value of `index` is printed to the console.
 * The loop continues until either the `if` condition becomes true (terminating the loop) or `index` reaches 200 (loop completes naturally).
 */
fun main() {
    var index = 1
    while (index < 200) {
        index *= 2
        if (index >= 300){
            break
        }
        println(index)
    }
}
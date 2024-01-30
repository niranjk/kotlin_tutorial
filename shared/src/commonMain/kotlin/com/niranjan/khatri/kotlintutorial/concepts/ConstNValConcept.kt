package com.niranjan.khatri.kotlintutorial.concepts

/**
 * `const` are used to declare compile-time constants
 * **const (Compile-time Constant):**
 * - `const` is used to declare constants that are known at compile time.
 * - It must be a top-level or a member of an object declaration or a companion object.
 * - The value is known and fixed at compile time.
 * - `const` is used for values that remain constant throughout the program execution.
 * - It can only be used with primitive types and strings.
 */
const val PI = 3.14
class ConstNValConcept {
    /**
     * `val` and `var` are used to declare variables with a value assigned at runtime.
     * **val (Immutable Variable):**
     * - `val` is used to declare read-only (immutable) variables.
     * - Once assigned a value, a `val` cannot be reassigned.
     * - The value can be determined at runtime.
     * - It's assigned during program execution.
     */
    /**
     * Const 'val' are only allowed on top level, in named objects, or in companion objects
     */
    // const val foo = doSth()
    val fooItem = doSth()
    val pi = 3.14
    // pi = 3.14159  // Error: Val cannot be reassigned

    /**
     * `const` can only be used at the top level or inside an object declaration or a companion object. It cannot be used within functions or local scopes.
     */
    companion object {
        const val bar = "BAR"
    }
    fun doSth(){ }
}
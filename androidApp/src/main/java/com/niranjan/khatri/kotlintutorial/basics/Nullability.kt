package com.niranjan.khatri.kotlintutorial.basics

/**
 * @author NIRANJAN KHATRI
 * @since 26/02/24
 * @version 1
 */

/**
 *   // Sentinel Values are the representation of absence of values
 *     var id = 0 // The default value representing absence
 *     // Kotlin way of representing absence is using null
 *     val nullyId: Int? = null // way of declaring a variable of nullable type
 */

/**
 * var name: String? = null
 *     name?.isNotEmpty()?.let{// Checking the nullability
 *         println("Name is: $name")
 *     }
 */

/***
 * var name : String? = "Niran"
 *     var age: Int? = 12
 *     age = age!!.plus(1)
 *     println("Age without Exception Thrown: $age\n")
 *     // Exception Thrown after you assign null and try to access the age value
 *     age = null
 *     println("Age with Exception Thrown: ${age!!}")
 */

fun main() {
    // Elvis Operator
    var name : String? = null
    var myname = name ?: "NiranJK" // Returns the Default Name in case of null
    printMyName(myname)
}
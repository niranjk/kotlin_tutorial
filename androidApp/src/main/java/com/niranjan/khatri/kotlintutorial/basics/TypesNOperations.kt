package com.niranjan.khatri.kotlintutorial.basics

/*
// Numbers
    val number_int : Int = 1
    val number_double : Double = 1.0
    val number_float : Float = 1F
    val number_short : Short = 14
    val number_byte : Byte = 20
 */

/*
// Chars
    val charsA : Char = 'a'
    // Strings
    val stringABC : String = "abc" // this right hand side of expression is called string literal
 */

/*
// Concatenation
    var stringLeftPart = "Hello"
    val stringRightPart = "Kotlin"
    var stringMessage = stringLeftPart + stringRightPart // concatenation
    val exclamation = '!'
    stringMessage+=exclamation
    println(stringMessage)
 */

/*
// String Templates
    // we can build string using string templates passing a $ symbol and value you want to pass
    val name = "Kotlin"
    val message = "Hello $name!"
    println(message)
    // Or you can pass the expression directly with the $ symbol as values
    val payMonthly = "You need to pay ${24000.00 /12.0}"
    println(payMonthly)
 */

/*
// Multi-line Strings
    val multiLineString = """
  |Hello
  |Kotlin
  |that contains multiple
  |lines
  |...
  |.
  """.trimMargin()
    println(multiLineString)
 */

/*
// Pair
    val coordinate_2D = Pair(1, 2)
    // or
    val coordinate_2D_alternate = 3 to 4
    var coordinates_doubles = Pair(1.2, 3.4)
    var coordinates_mixed = Pair(1, 3.4)
    // Accessing coordinates
    println("First: ${coordinates_mixed.first}")
    println("Second: ${coordinates_mixed.second}")
 */

/*
// Triple
    val coordinate_3D = Triple(1, 2, 3)
    // Accessing 3D coordinates
    println("First: ${coordinate_3D.first}")
    println("Second: ${coordinate_3D.second}")
    println("Third: ${coordinate_3D.third}")
 */

/*
// Any
    val anyString : Any = "Any String"
    val anyNumber : Any = 5
 */

/*
fun main() {
    // Unit
    unitReturningFunc()
}
fun unitReturningFunc() : Unit {
    print("This functions returns Unit")
}
 */
/*
fun main() {
    // Unit
    nothingFunc()
}
fun nothingFunc() : Nothing {
    try {
        // do something forever ...
        while (true){
            println("Do something forever")
        }
    } catch (e : Exception){
        throw Throwable("Stop + Throw this Exception")
    }
}
 */
/*
// Type Conversion
    val decimal_value = 145.23
    var int_value = decimal_value.toInt() // Type Conversion implementation
    print("Int Value: $int_value")
 */
fun main() {
    // Type Inversion
    val value = 2.3
    println(value)
}

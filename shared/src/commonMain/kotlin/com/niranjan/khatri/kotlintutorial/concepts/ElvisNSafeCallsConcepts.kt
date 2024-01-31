package com.niranjan.khatri.kotlintutorial.concepts

data class Person(val name: String?, val address: Address?)
data class Address(val city: String?)
fun printCity(person: Person?) {
    val city = person?.address?.city  // Safe Calls
    println("City: $city")
}

fun getLength(name: String?): Int {
    return name?.length ?: 0 // Elvis Operator
}

data class Book(val title: String?, val author: Author?)
data class Author(val name: String?)

fun getAuthorName(book: Book?): String {
    // Combination of Safe Calls and Elvis Operator
    return book?.author?.name ?: "Unknown Author"
}

fun main() {
    val personWithNullAddress = Person("John", null)
    val personWithNonNullAddress = Person("Alice", Address("Wonderland"))
    printCity(personWithNullAddress) // Outputs: City: null
    printCity(personWithNonNullAddress) // Outputs: City: Wonderland

    val lengthWithNull = getLength(null)
    val lengthWithNonNull = getLength("Kotlin")
    println("Length with null: $lengthWithNull") // Outputs: Length with null: 0
    println("Length with non-null: $lengthWithNonNull") // Outputs: Length with non-null: 6

    val bookWithNullAuthor = Book("The Kotlin Book", null)
    val bookWithNonNullAuthor = Book("The Java Book", Author("John Doe"))
    val authorNameWithNull = getAuthorName(bookWithNullAuthor)
    val authorNameWithNonNull = getAuthorName(bookWithNonNullAuthor)
    println("Author Name with null: $authorNameWithNull") // Outputs: Author Name with null: Unknown Author
    println("Author Name with non-null: $authorNameWithNonNull") // Outputs: Author Name with non-null: John Doe
}
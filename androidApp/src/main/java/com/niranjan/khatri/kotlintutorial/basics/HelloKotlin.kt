package com.niranjan.khatri.kotlintutorial.basics

fun main(){
    println("Hello Kotlin!")

    // list of number from 1 to 10
    val listOfNumbers = (1..10).toList()
    // Combine the elements of the list into a single string, separated by commas.
    val stringValues = listOfNumbers.joinToString(",")


    // LANGUAGE AGNOSTIC COMMENTS ----
    // Combine the elements of the list into a single string, separated by commas.
    // string_valueS = list_of_numbers_as_string

}
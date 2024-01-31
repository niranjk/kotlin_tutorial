package com.niranjan.khatri.kotlintutorial.concepts

// Creating a MutableList with initial elements
val mutableListWithElements: MutableList<String> = mutableListOf("Apple", "Banana", "Orange")

// Creating an empty MutableList using classic approach
val emptyMutableList: MutableList<String> = mutableListOf()

// Creating an empty MutableList using modern approach
val emptyMutableListModern: MutableList<String> = mutableListOf<String>()

// Creating an empty MutableList with type inference
val emptyMutableListInferred = mutableListOf<String>()

// Creating an empty ArrayList with type inference
val emptyArrayListInferred = ArrayList<String>()

// Creating an empty MutableList with initial capacity
val emptyMutableListWithCapacity = ArrayList<String>(10)
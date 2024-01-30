package com.niranjan.khatri.kotlintutorial.concepts

import kotlin.jvm.JvmStatic

/*
class Bar {
    public static int xyz() { return 0; } // Static
}
 */

class Bar {
    companion object {
        @JvmStatic // You can have this annotation to make it interoperable with Java and generate real static methods and fields
        fun xyz() : Int = 0 // static
    }
}
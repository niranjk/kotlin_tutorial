package com.niranjan.khatri.kotlintutorial

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
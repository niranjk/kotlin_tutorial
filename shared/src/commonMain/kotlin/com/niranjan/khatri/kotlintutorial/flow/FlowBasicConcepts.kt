package com.niranjan.khatri.kotlintutorial.flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class User(val name: String)
class UserRepository {
    private val _userData = MutableStateFlow<User?>(null)
    val userData: Flow<User?> = _userData
    suspend fun refreshUserData() {
        // Fetch user data from a network or database
        val newUser = fetchData()
// Update the flow with the new data
        _userData.value = newUser
        }
    private suspend fun fetchData(): User {
        // Simulated data fetching, replace this with your actual implementation
        // For simplicity, we're just returning a hardcoded User
        return User("Johnny The Leaver")
        }
}





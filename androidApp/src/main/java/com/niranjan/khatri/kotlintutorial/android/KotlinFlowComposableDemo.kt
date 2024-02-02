package com.niranjan.khatri.kotlintutorial.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.niranjan.khatri.kotlintutorial.flow.UserRepository
import kotlinx.coroutines.launch

@Composable
fun UserScreen(userRepository: UserRepository) {
    // Collect the user data as state
    val userData by userRepository.userData.collectAsState(initial = null)
// Create a coroutine scope for launching side effects
    val coroutineScope = rememberCoroutineScope()
// UI layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Display user data
        Text(text = "User Name: ${userData?.name?: "Loading…"}")
// Button to refresh user data
        BasicTextField(
        value = userData?.name?: "",
        onValueChange = {}
        )
// Button to refresh user data
        Button(onClick = {
        // Launch a coroutine to refresh user data
        coroutineScope.launch {
        userRepository.refreshUserData()
        }
        }) {
        Text("Refresh User Data")
        }
// Composable that observes the user data flow and displays a message
        UserMessage(userRepository = userRepository)
        }
}
@Composable
fun UserMessage(userRepository: UserRepository) {
    // Collect the user data as state in this composable
    val userData by userRepository.userData.collectAsState(initial = null)
// Display a message based on user data
    Text(
        text = "User Message: ${userData?.let { "Hello, ${it.name}!" }?: "No user data"}",
    modifier = Modifier.padding(top = 16.dp)
    )
}

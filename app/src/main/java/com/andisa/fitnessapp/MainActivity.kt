package com.andisa.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.andisa.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {

    // This function runs when the app starts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Allows the UI to extend to the edges of the screen
        enableEdgeToEdge()

        // setContent tells Android that we are using Jetpack Compose UI
        setContent {

            // Applies the theme for your app (colors, typography etc.)
            FitnessAppTheme {

                // Scaffold is the basic layout structure for Material apps
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    // Calls our navigation system
                    AppNavigation()
                }
            }
        }
    }
}

/*
This function controls navigation between screens
(Login → Register → Home)
*/
@Composable
fun AppNavigation() {

    // NavController controls switching between screens
    val navController = rememberNavController()

    // NavHost defines all the screens in the app
    NavHost(
        navController = navController,
        startDestination = "login" // First screen when the app opens
    ) {

        // Login Screen
        composable("login") {
            LoginScreen(

                // What happens when the login button is clicked
                onLoginClick = {
                    navController.navigate("home")
                },

                // Navigate to register screen
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }

        // Register Screen
        composable("register") {
            RegisterScreen(

                // After registering, go back to login
                onRegisterClick = {
                    navController.navigate("login")
                }
            )
        }

        // Home Screen (Fitness Dashboard)
        composable("home") {
            HomeScreen()
        }
    }
}

package com.example.little_lemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.little_lemon.screens.Home
import com.example.little_lemon.screens.Profile

@Composable
fun MyNavigation(navController: NavHostController, isLoggedin: Boolean) {

    NavHost(navController = navController, startDestination = if (isLoggedin) Home.route else Onboarding.route) {
        composable(Onboarding.route) {
            Onboarding(navController);
        }
        composable(Home.route) {
            Home(navController)
        }
        composable(Profile.route) {
            Profile(navController)
        }
    }
}

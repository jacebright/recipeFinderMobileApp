package com.example.recipefinder

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
//    Basic Nav Host to direct between the two application pages
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.HomeScreen, builder = {
        composable(Routes.HomeScreen) {
            HomeScreen(navController)
        }
        composable(Routes.RecipeScreen + "/{category}") {
            val category = it.arguments?.getString("category")
            RecipeScreen(category ?: "American")
        }
    })
}
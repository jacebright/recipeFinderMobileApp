package com.example.recipefinder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
//    User will select a filtering option
    val categories = listOf("Breakfast", "Dinner", "Side", "American", "Hispanic", "Dessert", "Asian", "Snack", "Beverage", "Soup", "Salad", "Bread", "Holidays", "Appetizer", "Main-course", "Vegetarian", "Baked-goods")
    LazyColumn (modifier = Modifier.padding(24.dp)) {

        items(categories) {
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Button(onClick = {
                    navController.navigate(Routes.RecipeScreen+"/${it}")
                }) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }

        }
    }
}


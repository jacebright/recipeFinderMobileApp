package com.example.recipefinder

data class Recipe(
    val name: String,
    val totalTime: String,
    val description: String,
    val categories: List<String>
) {



    fun hasCategory(category: String): Boolean {
//        Checks if a given category is applicable to the recipe
        return categories.contains(category)
    }

    fun getSummary(): String {
//        Used to provide a user-friendly summary
        return "$name: Time: $totalTime, $description"
    }

    fun getCSVFormat(): String {
//        consolidate the information into the desired format
        var recipeString = "$name,$totalTime,$description,"
        for (category in categories) {
            recipeString = "$recipeString$category|"
        }
        return recipeString
    }
}
package com.example.recipefinder

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Handle the recipes as global variables for public access.
var recipeList: HashSet<Recipe> = HashSet<Recipe>()
val recipeString: String =
    "Sausage Cheese Balls,40 minutes,Savory sausage and cheese bites with onion and garlic,Appetizer|Holidays\n" +
            "Christmas Tree Appetizers,20 minutes,Festive guacamole and bell peppers on pita triangles,Appetizer|Vegetarian|Holidays\n" +
            "Cocktail Meatballs,1 hour,Sweet and tangy cranberry meatballs perfect for holidays,Appetizer|Main-course|Holidays\n" +
            "Classic Cheesecake,4 hours,Rich and creamy cheesecake ideal for celebrations,Dessert|Holidays\n" +
            "Fluffy Pancakes,20 minutes,Fluffy homemade pancakes with syrup and butter,Breakfast|American\n" +
            "Garlic Butter Green Beans,15 minutes,Quick and easy green beans with a garlic butter glaze,Side|Vegetarian\n" +
            "Sweet Salty Spicy Party Nuts,30 minutes,Roasted party nuts with a sweet and spicy coating,Snack|Holidays\n" +
            "Vegan Waffles,15 minutes,Fluffy waffles made vegan-friendly with flaxseeds,Breakfast|Vegan\n" +
            "Vegetarian Chili,1 hour,Hearty vegetarian chili with beans and spices,Main-course|Vegetarian|Soup\n" +
            "Cheesy Pesto Roll Wreath,45 minutes,Savory cheesy roll in a wreath shape for the holidays,Appetizer|Holidays\n" +
            "King Crab Appetizers,30 minutes,Tender crab meat appetizers in phyllo cups,Appetizer|Holidays|Seafood\n" +
            "Classic Savory Deviled Eggs,25 minutes,Deviled eggs with dill and Dijon mustard,Appetizer|Vegetarian\n" +
            "Cheddar Cheese Straws,30 minutes,Classic Southern cheese straws crispy and savory,Appetizer|Holidays\n" +
            "Cream Cheese Penguins,20 minutes,Cute penguins made of olives cream cheese and carrots,Appetizer|Vegetarian|Holidays\n" +
            "Holiday Eggnog,15 minutes,Traditional creamy eggnog for the holiday season,Beverage|Holidays\n" +
            "Sausage Stuffed Mushrooms,25 minutes,Savory sausage-filled mushrooms with herbs and cheese,Appetizer|Holidays|Seafood\n" +
            "Mini Caprese Skewers,15 minutes,Fresh mozzarella tomato and basil on skewers with balsamic drizzle,Appetizer|Vegetarian\n" +
            "Spinach Artichoke Dip,40 minutes,Rich and creamy dip with spinach and artichokes,Appetizer|Vegetarian\n" +
            "Beef Empanadas,1 hour,Flaky pastry filled with seasoned ground beef onions and olives,Main-course|Hispanic\n" +
            "Chicken Alfredo Pasta Bake,1 hour,Comforting pasta baked with creamy Alfredo sauce and chicken,Main-course|Dinner\n" +
            "French Toast Casserole,1 hour,A breakfast casserole with cinnamon eggs and syrup,Breakfast|American\n" +
            "Baked Ziti,1 hour,Pasta baked with marinara sauce ricotta and mozzarella,Main-course|Vegetarian\n" +
            "Honey Glazed Carrots,30 minutes,Carrots glazed with honey and butter for a sweet savory side,Side|Vegetarian\n" +
            "Lemon Meringue Pie,2 hours,Classic dessert with tangy lemon curd and fluffy meringue,Dessert\n" +
            "Roasted Red Pepper Hummus,30 minutes,Smooth and flavorful hummus with roasted red peppers,Snack|Vegetarian\n" +
            "Pulled Pork Sandwiches,4 hours,Slow-cooked pulled pork served on buns with barbecue sauce,Main-course|American\n" +
            "Caesar Salad,20 minutes,Crisp romaine lettuce with Caesar dressing croutons and Parmesan,Salad|Vegetarian\n" +
            "Pineapple Coconut Smoothie,15 minutes,A tropical smoothie made with pineapple and coconut milk,Beverage|Vegetarian\n" +
            "Avocado Toast,10 minutes,Mashed avocado on toasted bread with a sprinkle of salt and pepper,Snack|Vegetarian\n" +
            "Buffalo Cauliflower Bites,30 minutes,Spicy crispy cauliflower served as a vegetarian alternative to buffalo wings,Side|Vegetarian\n" +
            "Eggplant Parmesan,1 hour,Layers of fried eggplant with marinara sauce and melted cheese,Main-course|Vegetarian\n" +
            "Chicken Tikka Masala,1 hour,A flavorful Indian dish with chicken in a spiced tomato-based sauce,Main-course|Asian\n" +
            "Lemon Bars,1 hour,Shortbread crust topped with tangy lemon filling and powdered sugar,Dessert\n" +
            "Tuna Salad,20 minutes,Classic tuna salad with mayo pickles and celery,Salad|Lunch\n" +
            "Baked Sweet Potatoes,1 hour,Roasted sweet potatoes with a soft caramelized center,Side|Vegetarian\n" +
            "Chocolate Chip Cookies,1 hour,Classic cookies with rich chocolate chips and chewy texture,Dessert\n" +
            "Pasta Primavera,30 minutes,Light pasta dish with fresh vegetables and olive oil,Main-course|Vegetarian\n" +
            "Grilled Cheese Sandwich,15 minutes,Comfort food with melted cheese between two crispy pieces of bread,Lunch|Vegetarian\n" +
            "Chicken Parmesan,1 hour,Chicken breaded and fried topped with marinara sauce and cheese,Main-course|American\n" +
            "Tomato Basil Soup,45 minutes,Comforting soup made with fresh tomatoes and basil,Soup|Vegetarian\n" +
            "Minestrone Soup,1 hour,Hearty soup with vegetables beans and pasta in a tomato broth,Soup|Vegetarian\n" +
            "Banana Bread,1 hour,Moist bread made with ripe bananas and cinnamon,Baked-goods\n" +
            "Fettuccine Carbonara,30 minutes,Pasta with eggs cheese pancetta and pepper,Main-course|Italian\n" +
            "Baked Salmon,35 minutes,Salmon fillets seasoned and baked to perfection,Main-course|Seafood\n" +
            "Vegetable Stir-fry,20 minutes,Quick stir-fried vegetables with soy sauce and sesame oil,Main-course|Asian|Vegetarian\n" +
            "Vegetable Samosas,1 hour,Flaky pastries filled with spiced potatoes and peas,Appetizer|Vegetarian|Asian\n" +
            "Chicken Caesar Wrap,20 minutes,Grilled chicken lettuce and Caesar dressing in a wrap,Main-course|Lunch\n" +
            "Pumpkin Pie,1 hour,Classic fall dessert with spiced pumpkin filling in a flaky crust,Dessert|Holidays\n" +
            "Chocoflan,4hr,Classic mexican dessert combining choclate cake and classic flan.,Holidays|Baked-goods|Hispanic|Dessert|"

var recipeStrings = recipeString.split("\n")

@Composable
fun RecipeScreen(category: String) {
//    Display the filtered variables based on the user choice in the home screen
    for (recipe in recipeStrings) {
        val recList = recipe.split(',')
        val categories = recList[3].split('|')
        val time = recList[1]
        recipeList.add(Recipe(recList[0], recList[2], time, categories))
    }
//    This function will ask for user input and use that input to filter down the list of recipes.
    val filteredRecipe = recipeList.filter { it.hasCategory(category) }
    LazyColumn {
        items(filteredRecipe) {
            Card(
                modifier = Modifier.padding(36.dp)
            ) {
                Text(
                    text = it.getSummary(),
                    modifier = Modifier.padding(36.dp)
                )
            }
        }
    }
}


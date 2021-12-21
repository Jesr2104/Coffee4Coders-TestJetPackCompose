package com.justjump.coffee4coders.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.screens.CheckoutScreen
import com.justjump.coffee4coders.ui.screens.DetailScreen
import com.justjump.coffee4coders.ui.screens.FeedScreen
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.utilities.MockDataProvider

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    Coffee4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost( navController = navController, startDestination = "feed"){

                composable(route = "feed"){
                    FeedScreen(navController)
                }

                composable(route = "detail/{productId}"){ backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId")?: "0"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductById(productId)
                    DetailScreen(navController, product!!)
                }

                composable(route = "checkout/{productId}"){ backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId")?: "0"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductById(productId)
                    CheckoutScreen(navController, product!!)
                }
            }
        }
    }
}
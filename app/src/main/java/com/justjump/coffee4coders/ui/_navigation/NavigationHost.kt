package com.justjump.coffee4coders.ui._navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.justjump.coffee4coders.ui.screens.CheckoutScreen
import com.justjump.coffee4coders.ui.screens.ConfirmationScreen
import com.justjump.coffee4coders.ui.screens.DetailScreen
import com.justjump.coffee4coders.ui.screens.FeedScreen
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.utilities.MockDataProvider

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    Coffee4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost(
                navController = navController,
                NavItem.Main.route)
            {

                composable(route = NavItem.Main.route){ FeedScreen(navController) }

                composable(
                    route = NavItem.Detail.route,
                    arguments = NavItem.Detail.args
                ){ backStackEntry ->
                    var idProduct = backStackEntry.arguments?.getInt("productId")!!
                    val product = MockDataProvider.getProductById(idProduct)
                    requireNotNull(product)
                    DetailScreen(navController, product)

                }

                composable(route = "checkout/{productId}"){ backStackEntry ->
                    val productIdString = backStackEntry.arguments?.getString("productId")?: "0"
                    val productId = productIdString.toInt()
                    val product = MockDataProvider.getProductById(productId)
                    requireNotNull(product)
                    CheckoutScreen(navController, product)
                }

                composable(route = "confirmation"){
                    ConfirmationScreen(navController)
                }
            }
        }
    }
}
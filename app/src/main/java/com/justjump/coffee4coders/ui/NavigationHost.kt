package com.justjump.coffee4coders.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.componets.CountryISO
import com.justjump.coffee4coders.ui.screens.CheckoutScreen
import com.justjump.coffee4coders.ui.screens.DetailScreen
import com.justjump.coffee4coders.ui.screens.FeedScreen
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    Coffee4CodersTheme {
        Surface(color = MaterialTheme.colors.background) {
            NavHost( navController = navController, startDestination = "feed"){

                composable(route = "feed"){
                    FeedScreen(navController)
                }

                composable(route = "detail/{countryIso}"){ backStackEntry ->
                    val countryIsoString = backStackEntry.arguments?.getString("countryIso")?: "COL"
                    val countryIso = CountryISO.valueOf(countryIsoString)
                    DetailScreen(navController, countryIso)
                }

                composable(route = "checkout/{countryIso}"){ backStackEntry ->
                    val countryIsoString = backStackEntry.arguments?.getString("countryIso")?: "COL"
                    val countryIso = CountryISO.valueOf(countryIsoString)
                    CheckoutScreen(navController, countryIso)
                }
            }
        }
    }
}
package com.justjump.coffee4coders.ui._navigation

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.screens.CheckoutScreen
import com.justjump.coffee4coders.ui.screens.ConfirmationScreen
import com.justjump.coffee4coders.ui.screens.ProductDetailsScreen
import com.justjump.coffee4coders.ui.screens.MainProductListScreen
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

                composable( route = NavItem.Main.route ){
                    MainProductListScreen{ productOnClick ->
                        navController.navigate(NavItem.Detail.createNavRoute(productOnClick.id))
                    }
                }

                composable(
                    route = NavItem.Detail.route,
                    arguments = NavItem.Detail.args
                ) { backStackEntry ->
                    val idProduct = backStackEntry.arguments?.getInt(NavArg.ProductId.Key)!!
                    val product = MockDataProvider.getProductById(idProduct)
                    requireNotNull(product)
                    ProductDetailsScreen(
                        product = product,
                        {navController.navigate(NavItem.Checkout.createNavRoute(it.id))},
                        {navController.popBackStack()}
                    )
                }

                composable(
                    route = NavItem.Checkout.route,
                    arguments =  NavItem.Checkout.args
                ){ backStackEntry ->
                    val idProduct = backStackEntry.arguments?.getInt(NavArg.ProductId.Key)!!
                    val product = MockDataProvider.getProductById(idProduct)
                    requireNotNull(product)
                    CheckoutScreen(
                        product = product,
                        {navController.navigate(NavItem.Confirmation.route)},
                        {navController.popBackStack()}
                    )
                }

                composable( route = NavItem.Confirmation.route ) {
                    ConfirmationScreen {
                        navController.navigate(NavItem.Main.route)
                    }
                }
            }
        }
    }
}
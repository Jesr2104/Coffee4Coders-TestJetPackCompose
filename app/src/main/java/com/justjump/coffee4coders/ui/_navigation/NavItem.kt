package com.justjump.coffee4coders.ui._navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList())
{
    // don't forget to specify the list of parameters
    //----------------------------------------------------------------------
    // list of routes
    //----------------------------------------------------------------------
        object Main: NavItem("feed")
        object Confirmation: NavItem("confirmation")

        object Detail: NavItem("detail", listOf(NavArg.ProductId)) {
            fun createNavRoute(productId: Int) = "$baseRoute/${productId}"
        }
        object Checkout: NavItem("checkout", listOf(NavArg.ProductId)) {
            fun createNavRoute(productId: Int) = "$baseRoute/${productId}"
        }
    //----------------------------------------------------------------------

    // this run create the navigation route with its parameters
    // for eg: baseRoute/{param1}...
    val route = run {
        val argKeys = navArgs.map { "{${it.Key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map { navArgument(it.Key){ type = it.navType} }
}

enum class NavArg(val Key: String, val navType: NavType<*>) {
    ProductId("productId", NavType.IntType)
}
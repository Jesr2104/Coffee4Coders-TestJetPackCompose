package com.justjump.coffee4coders.ui._navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NavArg> = emptyList())
{
    val route = run {
        val argKeys = navArgs.map { "{${it.Key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.Key){ type = it.navType}
    }


    object Main: NavItem("feed")
    object Detail: NavItem("detail", listOf(NavArg.ProductId))
}

enum class NavArg(val Key: String, val navType: NavType<*>) {
    ProductId("productId", NavType.IntType)
}
package com.justjump.coffee4coders.utilities

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.justjump.coffee4coders.ui.componets.NavigationAppBar

@Composable
fun SetSimpleAppBarWithBackButton(navController: NavController, titleOnAppBar: Int, buttonBack: Boolean = false){
    if (!buttonBack){
        NavigationAppBar(
            title = stringResource(titleOnAppBar),
            navigationIcon = Icons.Filled.ArrowBack){ navController.popBackStack() }
    } else {
        NavigationAppBar(title = stringResource(titleOnAppBar))
    }
}
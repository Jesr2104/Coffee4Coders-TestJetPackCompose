package com.justjump.coffee4coders.ui.componets

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.R

typealias navigationAction = () -> Unit

@Composable
fun TopBar(
    title: String? = null,
    navigationIcon: ImageVector? = Icons.Filled.ArrowBack,
    navigationAction: navigationAction? = null,
){

    // if the topBar don't have any title uses the title of the app
    val titleText = title ?: stringResource(R.string.app_name)

    if (navigationIcon != null && navigationAction != null) {
        TopAppBar(
            title = { Text(titleText) },
            navigationIcon = {
                IconButton(onClick = { navigationAction() }){
                    Icon(navigationIcon, "Button go back")
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {
        TopAppBar(
            title = { Text(titleText) },
            backgroundColor = MaterialTheme.colors.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarPreview(){
    TopBar("Title Screen", Icons.Filled.ArrowBack)
}


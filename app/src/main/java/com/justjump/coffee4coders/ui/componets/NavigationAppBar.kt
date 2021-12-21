package com.justjump.coffee4coders.ui.componets

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

typealias navigationAction = () -> Unit

@Composable
fun NavigationAppBar(
    title: String? = null,
    navigationIcon: ImageVector? = null,
    navigationAction: navigationAction? = null){

    val titleText = title ?: ""

    if (navigationIcon != null && navigationAction != null){
        TopAppBar (
            title = { Text(titleText)},
            navigationIcon = {
                IconButton(onClick = {
                    // here is missing the function of the button to go back
                    navigationAction()
                }){
                    Icon(navigationIcon, "")
                }
            },
            backgroundColor = MaterialTheme.colors.primary
        )
    } else {

        TopAppBar (
            title = { Text(titleText)},
            backgroundColor = MaterialTheme.colors.primary
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun NavigationBarItemView(){
    NavigationAppBar("Coffee4Coders")
}
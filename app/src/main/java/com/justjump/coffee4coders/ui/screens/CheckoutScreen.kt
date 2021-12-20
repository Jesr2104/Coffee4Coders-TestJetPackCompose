package com.justjump.coffee4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.ui.componets.TextFieldComponent
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun checkoutScreen(){

    var name by remember { mutableStateOf("")}

    TextFieldComponent(value = name, placeholder = "Name"){

    }

}

@Preview( showBackground = true)
@Composable
fun CheckoutScreenPreview(){

    Coffee4CodersTheme {
        checkoutScreen()
    }
}
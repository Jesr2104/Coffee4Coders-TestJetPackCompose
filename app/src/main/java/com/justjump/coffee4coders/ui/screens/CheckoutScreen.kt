package com.justjump.coffee4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.models.data.local.Product
import com.justjump.coffee4coders.ui.componets.*
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.utilities.MockDataProvider

@Composable
fun CheckoutScreen(navController: NavController, product: Product) {

    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}

    // this state val is to controller when show the dialog
    val showDialog = remember {mutableStateOf(false)}


    Scaffold(
        topBar = {
            NavigationAppBar(
                title = "Checkout",
                navigationIcon = Icons.Filled.ArrowBack){
                    navController.navigate("detail/${product.id}"){
                        popUpTo("detail")
                    }
                }
        },
        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ProductCard(product){}

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TextFieldComponent(value = name, placeholder = "full name"){ name = it }
                    TextFieldComponent(value = email, placeholder = "email"){ email = it }
                    TextFieldComponent(value = phone, placeholder = "phone number"){ phone = it }
                    TextFieldComponent(value = address, placeholder = "address"){ address = it }

                    DropdownTextField(
                        suggestions = MockDataProvider.listOfCities(),
                        value = city,
                        placeholder = "ciudad",
                    ){ city = it }

                    Column {
                        Row{
                            Text("Subtotal", style = MaterialTheme.typography.caption)
                            Text(
                                "35.95",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Row{
                            Text("parcel", style = MaterialTheme.typography.caption)
                            Text(
                                "9.75",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        Text(
                            "$ 45.70 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start
                        )
                        ButtonComponent(label = "Purchase"){
                            showDialog.value = true
                        }

                        // this is the call to the Alert function this one
                        // is call this the state of the show dialog is true.
                        if(showDialog.value) {
                            ShowAlertDialog(showDialog)
                        }
                    }
                }
            }
        }
    )
}

@Preview( showBackground = true)
@Composable
private fun CheckoutScreenPreview(){
    val navController = rememberNavController()
    val product = MockDataProvider.getProductById(0)
    if (product != null){
        Coffee4CodersTheme {
            CheckoutScreen(navController, product)
        }
    } else {
        Text("Error to show Preview")
    }
}
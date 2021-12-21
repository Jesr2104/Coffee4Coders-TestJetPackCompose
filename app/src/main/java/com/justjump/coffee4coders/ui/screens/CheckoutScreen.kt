package com.justjump.coffee4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.componets.*
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun CheckoutScreen(navController: NavController, country: CountryISO) {

    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}

    val cities = listOf(
        "Mexico City, Mexico",
        "The Havana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
    )

    val productName = "Colombian Coffee!!"
    val productSummary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."
    val productPrice = 35.95
    val productCurrency = "USD"

    Scaffold(
        topBar = {
            NavigationAppBar(
                title = "Checkout",
                navigationIcon = Icons.Filled.ArrowBack){
                    navController.navigate("detail/${country.iso}"){
                        popUpTo("detail")
                    }
                }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                ProductCard(
                    productName,
                    productSummary,
                    productPrice,
                    productCurrency,
                    country
                ){}

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TextFieldComponent(value = name, placeholder = "full name"){
                        name = it
                    }

                    TextFieldComponent(value = email, placeholder = "email"){
                        email = it
                    }

                    TextFieldComponent(value = phone, placeholder = "phone number"){
                        phone = it
                    }

                    TextFieldComponent(value = address, placeholder = "address"){
                        address = it
                    }

                    DropdownTextField(
                        suggestions = cities,
                        value = city,
                        placeholder = "ciudad",
                    ){
                        city = it
                    }

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
                        ButtonComponent(
                            label = "Purchase",
                        ){

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

    Coffee4CodersTheme {
        CheckoutScreen(navController, CountryISO.BRA)
    }
}
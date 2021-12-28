package com.justjump.coffee4coders.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.models.data.local.OrderInformation
import com.justjump.coffee4coders.models.data.local.Product
import com.justjump.coffee4coders.models.data.local.UserInformation
import com.justjump.coffee4coders.ui.componets.*
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.utilities.CountryISO
import com.justjump.coffee4coders.utilities.MockDataProvider
import com.justjump.coffee4coders.utilities.SetSimpleAppBarWithBackButton

@Composable
fun CheckoutScreen(navController: NavController, product: Product) {

    var name by remember { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("")}
    var address by remember { mutableStateOf("")}
    var postCode by remember { mutableStateOf("")}
    var city by remember { mutableStateOf("")}

    val SHIPPING_PRICE = 4.35
    val context = LocalContext.current
    val countryForIcon = CountryISO.valueOf(product.countryISO)
    val messageTextField = R.string.checkout_screen_message

    // this state val is to controller when show the dialog
    val showDialog = remember {mutableStateOf(false)}
    val isOrderComplete = remember { mutableStateOf(false)}

    Scaffold(
        topBar = { SetSimpleAppBarWithBackButton(navController, R.string.checkout_screen_title) },
        content = {
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
            ) {

                Text(
                    stringResource(R.string.checkout_screen_title_information),
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.ExtraBold
                )

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TextFieldComponent(value = name, placeholder = stringResource(R.string.checkout_screen_full_name)){ name = it }
                    TextFieldComponent(value = email, placeholder = stringResource(R.string.checkout_screen_email)){ email = it }
                    TextFieldComponent(value = phone, placeholder = stringResource(R.string.checkout_screen_phone_number)){ phone = it }

                    Row(horizontalArrangement = Arrangement.SpaceAround){
                        Column(
                            modifier = Modifier
                                .weight(4f)
                                .fillMaxWidth()
                        ) {
                            TextFieldComponent(value = address, placeholder = stringResource(R.string.checkout_screen_address)){ address = it }
                        }

                        Spacer(modifier = Modifier.width(10.dp))

                        Column(
                            modifier = Modifier
                                .weight(2f)
                                .fillMaxWidth()
                        ) {
                            TextFieldComponent(value = postCode, placeholder = stringResource(R.string.checkout_screen_post_code)){ postCode = it }
                        }
                    }

                    DropdownTextField(
                        suggestions = MockDataProvider.listOfCities(),
                        value = city,
                        placeholder = stringResource(R.string.checkout_screen_ciudad),
                    ){ city = it }


                    CheckProductDetail(
                        orderInformation = OrderInformation(
                            name = product.name,
                            textDescriptionProduct = stringResource(R.string.checkout_screen_title_pack_coffee),
                            iconFlag = countryForIcon.getBackgroundCountryFlag(),
                            qty = 1,
                            price = product.price,
                            currency = product.currency,
                        )
                    )

                    Column {
                        Row{
                            Text(stringResource(R.string.checkout_screen_subtotal), style = MaterialTheme.typography.caption)
                            Text(
                                text = "$ ${product.price} ${product.currency}",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))

                        Row{
                            Text(stringResource(R.string.checkout_screen_shipping), style = MaterialTheme.typography.caption)
                            Text(
                                text = "$ $SHIPPING_PRICE ${product.currency}",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row( horizontalArrangement = Arrangement.spacedBy(16.dp) ){
                        Text(
                            text = "$ ${getTotal(product.price.toString(),SHIPPING_PRICE.toString())} ${product.currency}",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.ExtraBold
                        )
                        ButtonComponent(label = stringResource(R.string.checkout_screen_button_text)){

                            if(name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty() &&
                                address.isNotEmpty() && postCode.isNotEmpty() && city.isNotEmpty()){
                                showDialog.value = true
                            }
                            else { Toast.makeText(context, messageTextField, Toast.LENGTH_SHORT).show() }
                        }

                        // this is the call to the Alert function this one
                        // is call this the state of the show dialog is true.
                        if(showDialog.value) {
                            val orderInformation = UserInformation(
                                name,
                                email,
                                phone,
                                address,
                                postCode,
                                city,
                                product.price.toString(),
                                SHIPPING_PRICE.toString(),
                                product.currency
                            )
                            ShowAlertDialog(orderInformation, showDialog, isOrderComplete)
                        }

                        if (isOrderComplete.value){
                            navController.navigate(route = "confirmation"){
                                launchSingleTop = true
                            }
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
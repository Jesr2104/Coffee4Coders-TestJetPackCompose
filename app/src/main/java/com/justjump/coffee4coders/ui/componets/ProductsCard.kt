package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.justjump.coffee4coders.models.data.local.Product
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.ui.theme.main_color1_coffee4coders
import com.justjump.coffee4coders.utilities.CountryISO
import com.justjump.coffee4coders.utilities.MockDataProvider

@Composable
fun ProductCard( product: Product, onClick: () -> Unit ){
    val country = CountryISO.valueOf(product.countryISO)?: CountryISO.COL

    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .size(480.dp)
        .clickable(onClick = onClick)
    ) {
        Image(painterResource(country.getBackgroundImage()), null)
        Surface( modifier = Modifier
            .fillMaxWidth(),
            color = main_color1_coffee4coders.copy(0.2f)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(product.name, //name title to the coffee
                    style = MaterialTheme.typography.h4)
                Text(product.summary, // description of the coffee and information
                    style = MaterialTheme.typography.body1
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Image(
                            painterResource(country.getBackgroundCountryFlag()), null,
                            modifier = Modifier.size(45.dp, 45.dp)
                        )
                        Text(
                            text = "$ ${product.price} ${product.currency}",
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(alignment = Alignment.Bottom),
                                // with this code we can align te text on the button
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4,

                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview(){
    val product = MockDataProvider.getProductById(0)
    if (product != null){
        Coffee4CodersTheme {
            ProductCard(product){}
        }
    } else {
        Text("Error to show Preview")
    }
}


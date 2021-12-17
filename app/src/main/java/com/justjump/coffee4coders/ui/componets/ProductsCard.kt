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
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.ui.theme.main_color1_coffee4coders

enum class CountryISO(val iso: String){
    COL("COL"),
    BRA("BRA"),
    CRI("CRI"),
    NIC("NIC");

    fun getBackgroundImage(): Int {
        return when(this){
            COL -> R.drawable._co
            BRA -> R.drawable._br
            CRI -> R.drawable._ri
            NIC -> R.drawable._ni
        }
    }

    fun getBackgroundCountryFlag(): Int {
        return when(this){
            COL -> R.drawable.flagco
            BRA -> R.drawable.flagbr
            CRI -> R.drawable.flagri
            NIC -> R.drawable.flagni
        }
    }
}

@Composable
fun ProductCard(name: String, summary: String, price: Double, currency: String, countryISO: CountryISO){

    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .size(480.dp)
        .clickable {  }
    ) {
        Image(painterResource(countryISO.getBackgroundImage()), null)
        Surface( modifier = Modifier
            .fillMaxWidth(),
            color = main_color1_coffee4coders.copy(0.2f)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(name, //name title to the coffee
                    style = MaterialTheme.typography.h4)
                Text(summary, // description of the coffee and information
                    style = MaterialTheme.typography.body1
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Image(
                            painterResource(countryISO.getBackgroundCountryFlag()), null,
                            modifier = Modifier.size(45.dp, 45.dp)
                        )
                        Text(
                            text = "$ $price $currency",
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
fun ProductCardPreview(){

    val name = "Colombian Coffee!!"
    val summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s."
    val price = 35.95
    val currency = "USD"


    Coffee4CodersTheme {
        ProductCard(name, summary, price, currency, CountryISO.COL)
    }
}


package com.justjump.coffee4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.ui.componets.BodyText
import com.justjump.coffee4coders.ui.componets.CountryISO
import com.justjump.coffee4coders.ui.componets.ProductCard
import com.justjump.coffee4coders.ui.componets.TitleText
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun FeedScreen(navController: NavController){

    val listISO = listOf<CountryISO>(
        CountryISO.COL,
        CountryISO.BRA,
        CountryISO.CRI,
        CountryISO.NIC,
    )

    Coffee4CodersTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                item {
                    Column( modifier = Modifier.padding(12.dp)) {
                        TitleText("Welcome to the coffee shop")
                        BodyText("There are many variations of passages of Lorem Ipsum available, " +
                                "but the majority have suffered alteration in some form, by injected humour," +
                                " or randomised words which don't look even slightly believable.")

                    }
                }
                items(listISO){ country ->
                    ProductCard(
                        name = "Colombian Coffee!!",
                        summary = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.",
                        price = 35.95,
                        currency = "USD",
                        country
                    ){
                        navController.navigate(route = "detail/${country.iso}"){
                            launchSingleTop = true
                        }
                    }
                }
                item {
                    Column(
                        // centre vertically the column
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(24.dp)
                    ){
                        TitleText("Thanks You!!")
                        BodyText("There are many variations of passages of Lorem Ipsum available, " +
                                "but the majority have suffered alteration in some form.")
                        Image(
                            painter = painterResource(R.drawable.beans),
                            null,
                            modifier = Modifier.size(45.dp, 45.dp)
                        )

                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FeedScreenPreview(){
    val navController = rememberNavController()

    FeedScreen(navController)
}
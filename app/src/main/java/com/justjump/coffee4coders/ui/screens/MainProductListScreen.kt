package com.justjump.coffee4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.models.data.local.Product
import com.justjump.coffee4coders.ui.componets.*
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme
import com.justjump.coffee4coders.utilities.MockDataProvider

@Composable
fun MainProductListScreen(onClickProduct: (Product) -> Unit){

    val list = MockDataProvider.listOfProducts()

    Coffee4CodersTheme {
        Scaffold(
            topBar = {
                TopBar()
            },
            content = {
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
                        items(list){ product ->
                            ProductCard(
                                product = product,
                                onClick = { onClickProduct(product) }
                            )
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
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FeedScreenPreview(){ MainProductListScreen(){} }

@Preview( showBackground = true, uiMode = UI_MODE_NIGHT_YES)

@Composable
private fun FeedScreenPreviewDark(){ MainProductListScreen(){} }
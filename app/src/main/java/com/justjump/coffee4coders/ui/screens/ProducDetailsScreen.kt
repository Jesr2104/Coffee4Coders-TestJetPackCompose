package com.justjump.coffee4coders.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.models.data.local.Product
import com.justjump.coffee4coders.ui.componets.BodyText
import com.justjump.coffee4coders.ui.componets.ButtonComponent
import com.justjump.coffee4coders.ui.componets.TitleText
import com.justjump.coffee4coders.ui.componets.TopBar
import com.justjump.coffee4coders.utilities.CountryISO

@Composable
fun ProductDetailsScreen(product: Product, onClickProduct: (Product) -> Unit, onClickBack: () -> Unit) {

    val countryIso = CountryISO.valueOf(product.countryISO)

    Scaffold (
        topBar = { TopBar(stringResource(R.string.detail_screen_title_top_bar), Icons.Filled.ArrowBack){ onClickBack() } },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box (modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                ){
                    Image(
                        painter = painterResource(id = countryIso.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(20.dp))
                {
                    TitleText(product.name)
                    Text(
                        textAlign = TextAlign.Justify,
                        color = Color.Black,
                        text = product.summary)
                    Spacer(modifier = Modifier.height(15.dp))
                    BodyText(title = product.Description)
                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("$ ${product.price} ${product.currency} ",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        ButtonComponent(
                            label = stringResource(R.string.detail_screen_button_purchase),
                            onClick = {onClickProduct(product)}
                        )
                    }
                }
            }
        }
    )
}
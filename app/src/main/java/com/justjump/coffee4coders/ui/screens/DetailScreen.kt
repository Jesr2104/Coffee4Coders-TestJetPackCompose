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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.componets.*
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun DetailScreen(navController: NavController, countryISO: CountryISO) {

    Scaffold (
        topBar = {
            NavigationAppBar(
                title = "Details",
                navigationIcon = Icons.Filled.ArrowBack){
                    navController.navigate("feed"){
                        popUpTo("feed")
                    }
            }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box (modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                ){
                    Image(
                        painter = painterResource(id = countryISO.getBackgroundImage()),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Column(modifier = Modifier.padding(20.dp))
                {
                    TitleText("Cafe de Colombia")
                    Text(
                        textAlign = TextAlign.Justify,
                        color = Color.Black,
                        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
                    Spacer(modifier = Modifier.height(15.dp))
                    BodyText(title = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                            "It has roots in a piece of classical Latin literature from 45 BC, " +
                            "making it over 2000 years old.")
                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text("$ 35.95 USD",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End
                        )
                        ButtonComponent("purchase"){
                            navController.navigate(route = "checkout/${countryISO.iso}"){
                                launchSingleTop = true
                            }
                        }
                    }

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview(){
    val navController = rememberNavController()

    Coffee4CodersTheme {
        DetailScreen(navController, CountryISO.BRA)
    }
}
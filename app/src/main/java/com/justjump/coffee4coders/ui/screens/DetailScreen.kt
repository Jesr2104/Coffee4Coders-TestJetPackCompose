package com.justjump.coffee4coders.ui.screens

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.componets.BodyText
import com.justjump.coffee4coders.ui.componets.CountryISO
import com.justjump.coffee4coders.ui.componets.NavigationAppBar
import com.justjump.coffee4coders.ui.componets.TitleText

@Composable
fun DetailScreen(navController: NavHostController, countryISO: CountryISO) {

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
                    Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(title = "Contrary to popular belief, Lorem Ipsum is not simply random text. " +
                            "It has roots in a piece of classical Latin literature from 45 BC, " +
                            "making it over 2000 years old.")
                    Spacer(modifier = Modifier.height(24.dp))

                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview(){
    val navController = rememberNavController()

    DetailScreen(navController, CountryISO.BRA)
}
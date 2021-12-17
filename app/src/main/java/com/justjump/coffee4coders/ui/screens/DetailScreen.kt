package com.justjump.coffee4coders.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.ui.componets.CountryISO
import com.justjump.coffee4coders.ui.componets.NavigationAppBar

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
            Column {
                Text("Soy un productos de ${countryISO.iso}",
                    style = TextStyle(color = Color.Black),
                    modifier = Modifier.padding(20.dp)
                )
                Button(
                    onClick = {
                        navController.navigate("feed"){
                            popUpTo("feed")
                        }
                    }
                ){
                    Text("Go back!!")
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
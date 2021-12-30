package com.justjump.coffee4coders.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.ui.componets.ButtonComponent
import com.justjump.coffee4coders.ui.componets.NavigationAppBar
import com.justjump.coffee4coders.ui.theme.Shapes
import com.justjump.coffee4coders.ui.theme.main_color_dark_grey
import com.justjump.coffee4coders.ui.theme.main_color_grey

@Composable
fun ConfirmationScreen( onClick: () -> Unit ) {

    Scaffold(
        topBar = { NavigationAppBar( title = "Summary" ) },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.orden_done), null,
                    modifier = Modifier.size(45.dp, 45.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Thank you for you order",
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(10.dp))

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Column(
                        Modifier
                            .height(10.dp)
                            .width(150.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = Shapes.small)
                                .background(main_color_grey)
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Column(
                        Modifier
                            .height(10.dp)
                            .width(130.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(150.dp)
                                .clip(shape = Shapes.small)
                                .background(main_color_grey)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "Order Confirmation Number",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Normal
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    "E-${getIdOrder()}OK",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.SemiBold
                )

                Column(
                    Modifier
                        .width(200.dp)
                ){
                    Spacer(modifier = Modifier.height(10.dp))
                    Canvas(modifier = Modifier.fillMaxWidth()) {
                        val canvasWidth = size.width
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0f),
                            end = Offset(0f,0f),
                            color = main_color_dark_grey,
                            strokeWidth = 1F
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painterResource(R.drawable.coffee_on_the_way), null,
                    modifier = Modifier.size(180.dp, 180.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    Modifier
                        .width(150.dp)
                ) {
                    ButtonComponent("Home"){
                        onClick()
                    }
                }
            }
        }
    )
}

fun getIdOrder(): String {
    var cont = 0
    var result = ""
    while (cont<6){
        result += (0..9).random()
        cont++
    }
    return result
}

@Preview(showBackground = true)
@Composable
private fun ConfirmationScreenPreview(){
    MaterialTheme {
        ConfirmationScreen(){}
    }
}
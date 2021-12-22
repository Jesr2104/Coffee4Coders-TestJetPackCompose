package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShowAlertDialog(showDialog: MutableState<Boolean>): Boolean {
    var result = false

    val name = "Jorge Soto Ramos"
    val email = "jksotoramos@hotmail.com"
    val phoneNumber = "07345610354"
    val address = "Robert Robertson, 1234 NW Bobcat Lane, St. Robert, MO 65584-5678"
    val city = "Medellín, Colombia"


    AlertDialog(

        modifier = Modifier.padding(5.dp),
        title = {
            Text(
                text = "Confirm Purchase",
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        text = {
            Column {
                Text("The information is correct?", style = TextStyle(color = Color.Black))
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append("Full Name: ")
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(name)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append("Email: ")
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(email)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append("Phone Nº: ")
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(phoneNumber)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append("City/Country: ")
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(city)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append("Address: ")
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(address)
                        }
                })
            }
            Row {
                // aqui va el total a pagar

            }
        },
        onDismissRequest = {
            showDialog.value = false
        },
        buttons = {
            Row(
                modifier = Modifier
                    .padding(0.dp,0.dp,0.dp,25.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center

            ) {
                Button(
                    onClick = { showDialog.value = false },
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 8.dp,
                        disabledElevation = 0.dp
                    ),
                    shape = MaterialTheme.shapes.medium,

                    ) {
                    Text("Cancel")
                    result = false
                }

                Spacer(modifier = Modifier.width(15.dp))

                Button(
                    onClick = { showDialog.value = false },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = Color.White
                    ),
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 6.dp,
                        pressedElevation = 8.dp,
                        disabledElevation = 0.dp
                    ),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text("Confirm")
                    result = true
                }
            }
        }
    )
    return result
}
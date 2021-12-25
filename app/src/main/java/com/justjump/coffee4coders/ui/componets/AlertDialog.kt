package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.models.data.local.UserInformation
import java.text.DecimalFormat

@Composable
fun ShowAlertDialog(
    UserInformation: UserInformation,
    showDialog: MutableState<Boolean>
){

    AlertDialog(

        modifier = Modifier.padding(5.dp),
        title = {
            Text(
                text = stringResource(R.string.alert_dialog_title),
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.ExtraBold
            )
        },
        text = {
            Column {
                Text(stringResource(R.string.alert_dialog_text),
                    style = TextStyle(color = Color.Black),
                    textAlign = TextAlign.Justify,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(stringResource(R.string.alert_dialog_information_user), fontWeight = FontWeight.SemiBold)

                Spacer(modifier = Modifier.height(5.dp))

                Canvas(modifier = Modifier.fillMaxWidth()) {
                    val canvasWidth = size.width
                    drawLine(
                        start = Offset(x = canvasWidth, y = 0f),
                        end = Offset(0f,0f),
                        color = Color.Gray,
                        strokeWidth = 2F,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append(stringResource(R.string.alert_dialog_full_name))
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(UserInformation.name)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append(stringResource(R.string.alert_dialog_email))
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(UserInformation.email)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append(stringResource(R.string.alert_dialog_phone_number))
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(UserInformation.phoneNumber)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append(stringResource(R.string.alert_dialog_country))
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(UserInformation.city)
                        }
                })

                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(MaterialTheme.colors.primary, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)){
                            append(stringResource(R.string.alert_dialog_address))
                        }
                        withStyle(SpanStyle(Color.Gray, fontSize = 12.sp)){
                            append(UserInformation.address)
                        }
                })


                Spacer(modifier = Modifier.height(20.dp))

                Column {
                    Row{
                        Text(stringResource(R.string.alert_dialog_subtotal), style = MaterialTheme.typography.caption, fontWeight = FontWeight.SemiBold)
                        Text(
                            "$ ${UserInformation.subtotal} ${UserInformation.currency}",
                            style = MaterialTheme.typography.body2,
                            fontSize = 12.sp,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Row{
                        Text(stringResource(R.string.alert_dialog_shipping), style = MaterialTheme.typography.caption, fontWeight = FontWeight.SemiBold)
                        Text(
                            "$ ${UserInformation.parcel} ${UserInformation.currency}",
                            style = MaterialTheme.typography.body2,
                            fontSize = 12.sp,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Canvas(modifier = Modifier.fillMaxWidth()) {
                        val canvasWidth = size.width
                        drawLine(
                            start = Offset(x = canvasWidth, y = 0f),
                            end = Offset(0f,0f),
                            color = Color.Gray,
                            strokeWidth = 2F,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))

                    Column() {
                        Row {
                            Text(stringResource(R.string.alert_dialog_total), style = MaterialTheme.typography.body2, fontWeight = FontWeight.SemiBold)
                            Text(
                                "$ ${getTotal(UserInformation.subtotal,UserInformation.parcel)} ${UserInformation.currency}",
                                style = MaterialTheme.typography.body2,
                                textAlign = TextAlign.End,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
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
                    Text(stringResource(R.string.alert_dialog_button_cancel))
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
                    Text(stringResource(R.string.alert_dialog_button_confirm))
                }
            }
        }
    )
}

fun getTotal(subtotal: String, parcel: String): String {
    val precision = DecimalFormat("0.00")
    return precision.format(subtotal.toDouble() + parcel.toDouble())
}
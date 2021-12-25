package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.justjump.coffee4coders.R
import com.justjump.coffee4coders.models.data.local.OrderInformation

@Composable
fun CheckProductDetail(orderInformation: OrderInformation){

    Column(
        modifier = Modifier
            .padding(0.dp,10.dp,0.dp,10.dp)
            .border(1.dp, Color.Black)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            Row {
                Image(
                    painter = painterResource(R.drawable.coffeebag),
                    null,
                    modifier = Modifier.size(60.dp, 60.dp)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Row {
                        Column {

                            Text(
                                text = orderInformation.name,
                                color = Color.Black,
                                fontWeight = FontWeight.SemiBold
                            )

                            Text(
                                text = orderInformation.textDescriptionProduct,
                                color = Color.Black,
                                fontSize = 10.sp,
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Surface(
                            ) {
                                Column {
                                    Image(
                                        painterResource(orderInformation.iconFlag), null,
                                        modifier = Modifier.size(15.dp, 15.dp)
                                    )
                                }
                            }
                        }

                        Text(
                            text = "$ ${orderInformation.price} ${orderInformation.currency}",
                            color = Color.Black,
                            textAlign = TextAlign.End,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                    Row {
                        Text(
                            text = "Quantity: ${orderInformation.qty}",
                            color = Color.Black,
                            textAlign = TextAlign.End,
                            fontSize = 10.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Preview( showBackground = true)
@Composable
private fun CheckProductDetailPreview(){

    val orderInformation = OrderInformation(
        name = "Colombian Coffee",
        textDescriptionProduct = "The best Coffee pack!!",
        iconFlag = R.drawable.flagco,
        qty = 1,
        price = 55.00,
        currency = "USD",
    )

    Box(modifier = Modifier.padding(20.dp)){

        CheckProductDetail(orderInformation)
    }
}
package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.justjump.coffee4coders.R

@Composable
fun ProductCard(){

    Card( modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .size(480.dp)
        .clickable {  }
    ) {
        Image(painterResource(R.drawable._co), null)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview(){
    ProductCard()
}


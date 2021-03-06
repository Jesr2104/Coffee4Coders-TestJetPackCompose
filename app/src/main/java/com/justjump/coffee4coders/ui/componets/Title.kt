package com.justjump.coffee4coders.ui.componets

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun TitleText(title: String){
    Text(title,
        style = MaterialTheme.typography.h3,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
private fun FeedScreenPreview(){
    Coffee4CodersTheme {
        TitleText("title")
    }
}
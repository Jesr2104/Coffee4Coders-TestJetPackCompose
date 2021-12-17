package com.justjump.coffee4coders.ui.componets

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

@Composable
fun BodyText(title: String){
    Text(title,
        style = MaterialTheme.typography.body2,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true)
@Composable
fun BodyTextPreview(){
    Coffee4CodersTheme {
        BodyText("title")
    }
}
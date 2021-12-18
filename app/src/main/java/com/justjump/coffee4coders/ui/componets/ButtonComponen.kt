package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme


typealias ButtonAction = () -> Unit

@Composable
fun ButtonComponent(label: String, action: ButtonAction){

    val upperCaseLabel = label.uppercase()

    Button(
        onClick = {action},
        modifier = Modifier.fillMaxWidth()
            .clickable{},
            // this one is one test to know if is possible setup the
            // button to get the effect to click on the button
        shape = MaterialTheme.shapes.medium,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        )
    ){
        Text(upperCaseLabel)
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonComponentPreview(){

    Coffee4CodersTheme {
        Box(modifier = Modifier.padding(20.dp)){
            ButtonComponent("Hola"){}
        }

    }
}
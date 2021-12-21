package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

typealias TrailingIcon = @Composable (()-> Unit)?
typealias OnGloballyPositioned = ((LayoutCoordinates)-> Unit)?
typealias OnValueChange = (String) -> Unit

@Composable
fun TextFieldComponent(
    value: String,
    placeholder: String,
    enable: Boolean = true,
    trailingIcon: TrailingIcon = null,
    onGloballyPositioned: OnGloballyPositioned = null,
    onValueChange: OnValueChange
){
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        // when the Text field get text from the keyboard it gonna be black
        textStyle = TextStyle(Color.Black),
        label = {
            Text(placeholder,
            style = MaterialTheme.typography.caption
            )
        },
        modifier = Modifier.fillMaxWidth()
            .onGloballyPositioned {
                if (onGloballyPositioned != null){
                    onGloballyPositioned(it)
                }
            },
        enabled = enable,
        keyboardActions = KeyboardActions (
            onDone = {focusManager.clearFocus()}
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        trailingIcon = trailingIcon
    )
}

@Preview( showBackground = true)
@Composable
private fun TextFieldComponentPreview(){

    Coffee4CodersTheme {
        TextFieldComponent("",""){ }
    }
}
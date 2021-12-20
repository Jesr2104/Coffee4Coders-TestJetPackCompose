package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

typealias OnchangeValue = (String) -> Unit

@Composable
fun DropdownTextField(suggestions: List<String>,
                      value: String,
                      placeholder: String,
                      onChangeValue: OnchangeValue
){
    Column {
        TextFieldComponent(
            value = value,
            placeholder = placeholder,
            onValueChange = onChangeValue
        )
    }

}

@Preview( showBackground = true)
@Composable
fun DropdownTextFieldPreview(){

    Coffee4CodersTheme {
        //DropdownTextField()
        TODO()
    }
}
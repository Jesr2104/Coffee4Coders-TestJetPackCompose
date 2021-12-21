package com.justjump.coffee4coders.ui.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.toSize
import com.justjump.coffee4coders.ui.theme.Coffee4CodersTheme

typealias OnchangeValue = (String) -> Unit

@Composable
fun DropdownTextField(suggestions: List<String>,
                      value: String,
                      placeholder: String,
                      onChangeValue: OnchangeValue
){
    var expanded by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = Icons.Filled.ArrowDropDown

    Column {
        TextFieldComponent(
            value = value,
            placeholder = placeholder,
            onValueChange = onChangeValue,
            enable = false,
            trailingIcon = {
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }
                )
            },
            onGloballyPositioned = {
                textFieldSize = it.size.toSize()
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {expanded = false},
            modifier = Modifier.width(with(LocalDensity.current){
                textFieldSize.width.toDp()
            })
        ){
            suggestions.forEach{ label ->
                DropdownMenuItem(onClick = {
                    onChangeValue(label)
                }){
                    Text(label, style = MaterialTheme.typography.body2)
                }
            }
        }
    }

}

@Preview( showBackground = true)
@Composable
private fun DropdownTextFieldPreview(){

    val cities = listOf(
        "Mexico City, Mexico",
        "The Havana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panama"
        )

    Coffee4CodersTheme {
        DropdownTextField(
            cities,
            "",
            "Cities"
        ){

        }
    }
}
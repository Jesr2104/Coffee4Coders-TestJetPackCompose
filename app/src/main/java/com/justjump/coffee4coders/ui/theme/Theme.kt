package com.justjump.coffee4coders.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = main_color1_coffee4coders,
    primaryVariant = main_color1_coffee4coders,
    secondary = main_color2_coffee4coders
)

private val LightColorPalette = lightColors(
    primary = main_color1_coffee4coders,
    primaryVariant = main_color1_coffee4coders,
    secondary = main_color2_coffee4coders
)

@Composable
fun Coffee4CodersTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
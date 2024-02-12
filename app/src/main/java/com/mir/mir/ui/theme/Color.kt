package com.mir.mir.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val BackgroundBtn = Color(0xFF896AEE)
val BackgroundBtnGrey = Color(0xFFF2F2F2)
val TextNotActiv = Color(0xFFD5D1D1)
val MainBackground = Color(0xFFFFFFFF)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

sealed class ThemeColors(
    val surface:Color,
    val onSurface:Color,
    val accentColor:Color,
    val onAccentColor:Color,
    val secondary:Color,
    val onSecondary:Color,
    val error:Color
){
    object Day:ThemeColors(
        surface = Color(0xFFFFFFFF),
        onSurface =Color(0xFF161617),
        accentColor = Color(0xFF896AEE),
        onAccentColor = Color(0xFFFFFFFF),
        secondary = Color(0xFFF2F2F2),
        onSecondary = Color(0xFFD5D1D1),
        error = Color(0xFFEB5353)
    )
    object Night:ThemeColors(
        surface = Color(0xFF161617),
        onSurface =Color(0xFFFFFFFF),
        accentColor = Color(0xFF896AEE),
        onAccentColor = Color(0xFFFFFFFF),
        secondary = Color(0xFFF2F2F2),
        onSecondary = Color(0xFFD5D1D1),
        error = Color(0xFFEB5353)
    )
}
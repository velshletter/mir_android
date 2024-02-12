package com.mir.mir.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    surface = ThemeColors.Night.surface,
    onSurface = ThemeColors.Night.onSurface,
    primary = ThemeColors.Night.accentColor,
    onPrimary = ThemeColors.Night.onAccentColor,
    secondary=ThemeColors.Night.secondary,
    onSecondary = ThemeColors.Night.onSecondary,
    error = ThemeColors.Night.error

)

private val LightColorScheme = lightColorScheme(
    surface = ThemeColors.Night.surface,
    onSurface = ThemeColors.Night.onSurface,
    primary = ThemeColors.Night.accentColor,
    onPrimary = ThemeColors.Night.onAccentColor,
    secondary=ThemeColors.Night.secondary,
    onSecondary = ThemeColors.Night.onSecondary,
    error = ThemeColors.Night.error

)

@Composable
fun MirTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
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
    surface = ThemeColors.Day.surface,
    onSurface = ThemeColors.Day.onSurface,
    primary = ThemeColors.Day.accentColor,
    onPrimary = ThemeColors.Day.onAccentColor,
    secondary=ThemeColors.Day.secondary,
    onSecondary = ThemeColors.Day.onSecondary,
    error = ThemeColors.Day.error
)

@Composable
fun MirTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        typography = Typography,
        content = content
    )
}
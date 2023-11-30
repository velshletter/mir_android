package com.mir.mir.ui.screens

enum class Screen {
    HOME,
    LOGIN,
    REGISTRATION
}
sealed class NavigationItem(val route: String) {
    object Home : NavigationItem(Screen.HOME.name)
    object Login : NavigationItem(Screen.LOGIN.name)
    object Registration : NavigationItem(Screen.REGISTRATION.name)
}
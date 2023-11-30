package com.mir.mir.ui.screens


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.Login.route,
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavigationItem.Registration.route) {
                SignInScreen(navController)
            }
            composable(NavigationItem.Home.route) {
                MainScreen(navController)
            }
        }
    }


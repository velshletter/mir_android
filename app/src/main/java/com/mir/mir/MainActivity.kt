package com.mir.mir

import FillProfileInfoScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mir.mir.screen.CreateAccount.ScreenCreateAccountFinal
import com.mir.mir.screen.CreateAccount.FillProfile.InterestsScreen
import com.mir.mir.screen.CreateAccount.FillProfile.Options1Screen
import com.mir.mir.screen.CreateAccount.FillProfile.Options2Screen
import com.mir.mir.screen.CreateAccount.LocationManualScreen
import com.mir.mir.screen.CreateAccount.TurnOnYourLocationScreen
import com.mir.mir.screen.SingIn.SingInView
import com.mir.mir.ui.theme.MirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}
@Composable
fun Navigation() {
    MirTheme(darkTheme = false) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "SingInView") {
            composable("SingInView") {
                SingInView(navController)
//                LocationManualScreen(navController)
            }
            composable("ScreenCreateAccountFinal") {
                ScreenCreateAccountFinal(navController)
            }
            composable("ProfileView"){
                FillProfileInfoScreen(navController)
//                TurnOnYourLocationScreen(navController)
            }
            composable("FillOption1"){
                Options1Screen(navController)
            }
            composable("FillOption2"){
                Options2Screen(navController)
            }
            composable("InterestsScreen"){
                InterestsScreen(navController)
            }
            composable("TurnOnLocationScreen"){
                TurnOnYourLocationScreen(navController)
            }
        }
    }
}
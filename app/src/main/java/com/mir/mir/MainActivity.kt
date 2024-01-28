package com.mir.mir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mir.mir.screen.CreateAccount.CreateAccountView
import com.mir.mir.screen.SingIn.SingInView
import com.mir.mir.ui.theme.MirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "SingInView") {
                composable("SingInView") {
                    SingInView {
                        navController.navigate("CreateAccountView")
                    }
                }
                composable("CreateAccountView") {
                    CreateAccountView{
                        navController.navigate("CreateAccountView")
                    }
                }
            }

            /*                                                        *** Создам тему на днях ***
            MirTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  //  AppNavHost(navController = rememberNavController())
                }
            }*/
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    MirTheme {

    }
}
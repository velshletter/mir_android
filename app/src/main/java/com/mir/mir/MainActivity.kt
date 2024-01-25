package com.mir.mir

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mir.mir.screen.CreateAccountView
import com.mir.mir.ui.theme.MirTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CreateAccountView()
           // SingInView()
            /*
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
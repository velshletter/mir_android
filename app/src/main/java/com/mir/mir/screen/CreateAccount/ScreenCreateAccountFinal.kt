package com.mir.mir.screen.CreateAccount

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mir.mir.R
import com.mir.mir.screen.CustomTextFieldOrigin
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey
import com.mir.mir.ui.theme.TextNotActiv


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenCreateAccountFinal(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_back),
                            contentDescription = "Back", Modifier.size(26.dp)
                        )
                    }
                })
        },
        bottomBar = {
            ButtonResume(onCLick = {navController.navigate("ProfileView")}, checkedState = false)

        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            BoxEmailPassword()
        }

    }
}

@Composable
fun BoxEmailPassword() {
    val checkedState = remember { mutableStateOf(false) }

    Column(Modifier.padding(start = 16.dp, end = 16.dp)) {
        Text(
            text = stringResource(id = R.string.createAcc),
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
        )
        Text(
            text = stringResource(id = R.string.input_telephone),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        CustomTextFieldOrigin(stringResource(id = R.string.email), false)
        CustomTextFieldOrigin(
            stringResource(id = R.string.password), true)
        CustomTextFieldOrigin(
            stringResource(id = R.string.repeat_password),true
        )
        Row(Modifier.padding(top = 15.dp)) {

              Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Gray,
                    checkedColor = BackgroundBtn,
                    checkmarkColor = Color.White
                )
            )
            Text(
                stringResource(id = R.string.agreement_policy),
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.headlineMedium
            )
        }
        BoxSignIn()
    }


}


@Composable
fun BoxSignIn() {


    Box(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(), contentAlignment = Alignment.BottomCenter
    ) {


        Column() {


            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary)

            ) {}


            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 15.dp, bottom = 15.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(id = R.string.you_already_have_an_account),
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                TextButton(onClick = {}) {
                    Text(
                        text = stringResource(id = R.string.enter),
                        color = BackgroundBtn,
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }


        }
    }
}

@Composable
fun ButtonResume(
    onCLick:() -> Unit,
    checkedState: Boolean
) {
    Box(
        Modifier
            .background(
                color = if (checkedState) {
                    BackgroundBtnGrey
                } else {
                    Color.Transparent
                }
            )
            .padding(start = 16.dp, end = 16.dp, bottom = 25.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Button(
            onClick = onCLick,
            colors = ButtonDefaults.buttonColors(
                contentColor = if (checkedState) {
                    Color.White
                } else {
                    TextNotActiv
                },
                containerColor = if (checkedState) {
                    BackgroundBtn
                } else {
                    Color.Transparent
                },
            ),
            modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp)

        ) {
            Text(
                text = stringResource(id = R.string.resume),
                style = MaterialTheme.typography.labelMedium,
                color = if (checkedState) {
                    Color.White
                } else {
                    TextNotActiv
                }
            )

        }

    }
}



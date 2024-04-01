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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mir.mir.R
import com.mir.mir.screen.ButtonResume
import com.mir.mir.screen.CreateAccount.FillProfile.FillProfileViewModel
import com.mir.mir.screen.CustomTextField
import com.mir.mir.screen.HeaderLarge
import com.mir.mir.screen.HeaderMedium
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey
import com.mir.mir.ui.theme.TextNotActiv


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScreenCreateAccountFinal(
    navController: NavController,
    viewModel: FillProfileViewModel = viewModel()
) {

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
            Surface {
                Column {
                    BoxSignIn()
                    ButtonResume(
                        onCLick = { navController.navigate("ProfileView") },
                        checkedState = false
                    )
                }
            }
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            BoxEmailPassword(viewModel = viewModel)
        }
    }
}

@Preview
@Composable
fun BoxEmailPassword(viewModel: FillProfileViewModel = viewModel()) {
    val checkedState = remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("")}
    var repeatedPassword by remember { mutableStateOf("")}

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.icon_visibility)
    } else {
        painterResource(id = R.drawable.icon_not_visibility)
    }
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderLarge("Создать аккаунт")
        Text(
            text = stringResource(id = R.string.input_your_email),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        HeaderMedium("Почта")
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Введите почту",
            value = viewModel.nameState.value,
            onValueChange = { viewModel.nameState.value = it },
            trailingIcon = {

                Icon(
                    painter = painterResource(id = R.drawable.icon_email),
                    contentDescription = "Visibility password",
                    Modifier.size(20.dp)
                )

            }
        )
        HeaderMedium(text = "Пароль")
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Введите пароль",
            value = password,
            onValueChange = { password = it },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility password",
                        Modifier.size(20.dp)
                    )
                }
            }
        )
        HeaderMedium(text = "Повторите пароль")
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Повторите пароль",
            value = repeatedPassword,
            onValueChange = { repeatedPassword = it },
            visualTransformation = if (passwordVisibility) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility password",
                        Modifier.size(20.dp)
                    )

                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp)
        ) {
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
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun BoxSignIn() {
    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
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
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
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
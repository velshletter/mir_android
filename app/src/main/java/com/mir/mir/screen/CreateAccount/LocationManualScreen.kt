package com.mir.mir.screen.CreateAccount

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationManualScreen(
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
                            contentDescription = "Back", Modifier.size(24.dp)
                        )
                    }
                })
        },
        bottomBar = {
            ButtonResume(
                onCLick = {
//                    navController.navigate("")
                },
                checkedState = false
            )

        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            LocationManualLayout(viewModel)
        }
    }
}

@Preview()
@Composable
fun LocationManualLayout(viewModel: FillProfileViewModel = viewModel()) {
    var showCountryMenu by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp),
    ) {
        HeaderLarge("Заполните Ваше местоположение")
        HeaderMedium("Страна")
        CustomTextField(
            modifier = Modifier.fillMaxWidth()
                .clickable {
                    showCountryMenu = true
                },
            placeholder = "Введите страну",
            value = viewModel.country.value,
            onValueChange = { viewModel.country.value = it },
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = null
                )
            }
        )
        DropdownMenu(
            expanded = showCountryMenu,
            onDismissRequest = { showCountryMenu = false },
        ) {
            Log.d("MyLog", "iiii")
            DropdownMenuItem(
                text = { Text("РАСИЯ") },
                onClick = {}
            )
        }
        HeaderMedium("Город")
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Введите город",
            value = viewModel.city.value,
            onValueChange = { viewModel.city.value = it },
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = null
                )
            }
        )
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu() {
    val context = LocalContext.current
    val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha", "Americano", "Cappuccino", "Espresso", "Latte", "Mocha","Americano", "Cappuccino", "Espresso", "Latte", "Mocha","Americano", "Cappuccino", "Espresso", "Latte", "Mocha",)
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { Image(
                    painter = painterResource(R.drawable.baseline_keyboard_arrow_down_24),
                    contentDescription = null
                ) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                coffeeDrinks.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedText = item
                            expanded = false
//                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        },
                    )
                }
            }
        }
    }
}
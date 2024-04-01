package com.mir.mir.screen.CreateAccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mir.mir.R
import com.mir.mir.screen.ButtonResume
import com.mir.mir.screen.CreateAccount.FillProfile.FillProfileViewModel
import com.mir.mir.ui.theme.BackgroundBtn

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TurnOnYourLocationScreen(
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
                }
            )

        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            TurnOnLocationLayout(viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TurnOnLocationLayout(viewModel: FillProfileViewModel = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize().padding(start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_location_on_128),
            contentDescription = "loactionIcon",
            colorFilter = ColorFilter.tint(BackgroundBtn)
        )
        Text(
            text = "Включите свое местоположение",
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Text(
            text = "Включите использование вашего местоположения, чтобы показать людей поблизости",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        Text(
            text = "Ввести вручную",
            style = MaterialTheme.typography.displayMedium,
            color = BackgroundBtn,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 28.dp, bottom = 8.dp)
                .clickable {
//                    navController.navigate("")
                }
        )
    }
}
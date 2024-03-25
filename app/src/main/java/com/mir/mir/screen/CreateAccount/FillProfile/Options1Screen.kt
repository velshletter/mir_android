package com.mir.mir.screen.CreateAccount.FillProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mir.mir.R
import com.mir.mir.options1
import com.mir.mir.screen.CreateAccount.ButtonResume
import com.mir.mir.screen.HeaderLarge
import com.mir.mir.screen.HeaderMedium
import com.mir.mir.screen.SelectItem
import com.mir.mir.ui.theme.MirTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Options1Screen(
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
                    navController.navigate("FillOption2")
                }, checkedState = false
            )

        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Options1Layout(viewModel)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Options1Layout(viewModel: FillProfileViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderLarge(stringResource(R.string.fill_your_profile))
        Spacer(Modifier.size(8.dp))
        val goals = options1.find { it.key == "goal" }!!
        HeaderMedium(text = goals.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in goals.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.goals.value.equals(name)
                ) {
                    viewModel.goals.value = name
                }
            }
        }
        val alcohol = options1.find { it.key == "alcohol" }!!
        HeaderMedium(text = alcohol.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in alcohol.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.alcohol.value.equals(name)
                ) {
                    viewModel.alcohol.value = name
                }
            }
        }
        val smoking = options1.find { it.key == "smoking" }!!
        HeaderMedium(text = smoking.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in smoking.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.smoking.value.equals(name)
                ) {
                    viewModel.smoking.value = name
                }
            }
        }
        val sport = options1.find { it.key == "sport" }!!
        HeaderMedium(text = sport.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in sport.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.sport.value.equals(name)
                ) {
                    viewModel.sport.value = name
                }
            }
        }
    }
}

@Preview()
@Composable
fun Preview() {
    MirTheme(darkTheme = false) {
        Options1Screen(rememberNavController(), viewModel())
    }
}

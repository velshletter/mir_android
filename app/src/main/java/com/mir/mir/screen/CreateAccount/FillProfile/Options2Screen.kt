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
import com.mir.mir.options2
import com.mir.mir.screen.CreateAccount.ButtonResume
import com.mir.mir.screen.HeaderLarge
import com.mir.mir.screen.HeaderMedium
import com.mir.mir.screen.SelectItem
import com.mir.mir.ui.theme.MirTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Options2Screen(
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
                    navController.navigate("InterestsScreen")
                }, checkedState = false
            )

        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Options2Layout(viewModel)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Options2Layout(viewModel: FillProfileViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderLarge(stringResource(R.string.fill_your_profile))
        Spacer(Modifier.size(8.dp))
        val education = options2.find { it.key == "education" }!!
        HeaderMedium(text = education.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in education.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.education.value.equals(name)
                ) {
                    viewModel.education.value = name
                }
            }
        }
        val zodiac = options2.find { it.key == "zodiac" }!!
        HeaderMedium(text = zodiac.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in zodiac.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.zodiac.value.equals(name)
                ) {
                    viewModel.zodiac.value = name
                }
            }
        }
        val type = options2.find { it.key == "type" }!!
        HeaderMedium(text = type.label)
        FlowRow(
            modifier = Modifier.wrapContentSize().padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            for (name in type.options) {
                SelectItem(
                    text = name,
                    isSelected = viewModel.type.value.equals(name)
                ) {
                    viewModel.type.value = name
                }
            }
        }
    }
}

@Preview
@Composable
fun FillOptions2ScreenPreview() {
    MirTheme(darkTheme = false) {
        Options2Screen(rememberNavController(), viewModel())
    }
}
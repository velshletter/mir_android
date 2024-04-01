import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.mir.mir.R
import com.mir.mir.screen.AddPhotoButton
import com.mir.mir.screen.ButtonResume
import com.mir.mir.screen.CustomTextField
import com.mir.mir.screen.CreateAccount.FillProfile.FillProfileViewModel
import com.mir.mir.screen.HeaderLarge
import com.mir.mir.screen.HeaderMedium
import com.mir.mir.screen.SelectItem
import com.mir.mir.ui.theme.MirTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FillProfileInfoScreen(navController: NavController, viewModel: FillProfileViewModel = viewModel()) {

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
                navController.navigate("FillOption1")
                    Log.d("MyLog", viewModel.sex.value)
                }
            )

        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            FillProfileLayout(viewModel)
        }
    }
}


@Composable
fun FillProfileLayout(viewModel: FillProfileViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        HeaderLarge(stringResource(R.string.fill_your_profile))
        HeaderMedium(text = stringResource(R.string.name))
        CustomTextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Введите имя",
            value = viewModel.nameState.value,
            onValueChange = { viewModel.nameState.value = it },
        )
        HeaderMedium(text = stringResource(R.string.date_birth))
        BirthDayPicker(viewModel)
        HeaderMedium(text = stringResource(R.string.sex))
        SexSelector(viewModel)
        HeaderMedium(text = stringResource(R.string.height))
        CustomTextField(
            modifier = Modifier.width(112.dp),
            placeholder = "См",
            textAlign = TextAlign.Center,
            value = viewModel.height.value,
            onValueChange = {
                if (it.length <= 3) viewModel.height.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center),
        )
        HeaderMedium(text = "Расскажи о себе")
        CustomTextField(
            modifier = Modifier.fillMaxWidth().heightIn(min = 256.dp),
            placeholder = "Введите текст",
            singleLine = false,
            value = viewModel.aboutYourself.value,
            onValueChange = { viewModel.aboutYourself.value = it },
        )
        HeaderMedium(text = "Добавить фотографии")
        AddPhotoLayout(viewModel = viewModel)
    }
}

@Composable
fun BirthDayPicker(viewModel: FillProfileViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomTextField(
            modifier = Modifier.width(112.dp),
            placeholder = "ДД",
            textAlign = TextAlign.Center,
            value = viewModel.birthDay.value,
            onValueChange = {
                if (it.length <= 2) viewModel.birthDay.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center),
        )
        CustomTextField(
            modifier = Modifier.width(112.dp),
            placeholder = "ММ",
            textAlign = TextAlign.Center,
            value = viewModel.birthMounth.value,
            onValueChange = {
                if (it.length <= 2) viewModel.birthMounth.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center),
        )
        CustomTextField(
            modifier = Modifier.width(112.dp),
            placeholder = "ГГГГ",
            textAlign = TextAlign.Center,
            value = viewModel.birthYear.value,
            onValueChange = {
                if (it.length <= 4) viewModel.birthYear.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = MaterialTheme.typography.headlineMedium.copy(textAlign = TextAlign.Center),
        )
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun AddPhotoLayout(viewModel: FillProfileViewModel) {
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            if (it != null) {
                viewModel.selectImages.value = viewModel.selectImages.value + it
            }
        }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth().heightIn(min = 228.dp, max = 480.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        itemsIndexed(viewModel.selectImages.value) { index, uri ->
            Box(
                modifier = Modifier.height(228.dp).width(172.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
            ) {
                Image(
                    painter = rememberImagePainter(uri),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null
                )
                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    onClick = {
                        viewModel.selectImages.value =
                            viewModel.selectImages.value.toMutableList().apply {
                                removeAt(index)
                            }
                    },
                ) {
                    Icon(
                        painter = painterResource(R.drawable.cross),
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }
        }
        if (viewModel.selectImages.value.size <= 3) {
            item {
                AddPhotoButton(onClick = { galleryLauncher.launch("image/*") })
            }
        }
    }
}

@Composable
fun SexSelector(viewModel: FillProfileViewModel) {


    Row {
        SelectItem(
            text = "Мужчина",
            isSelected = viewModel.sex.value == "Мужчина"
        ) {
            viewModel.sex.value = "Мужчина"
        }
        Spacer(Modifier.size(8.dp))
        SelectItem(
            text = "Женщина",
            isSelected = viewModel.sex.value == "Женщина"
        ) {
            viewModel.sex.value = "Женщина"
        }
    }
}

@Preview()
@Composable
fun FillProfilePreview() {
    MirTheme(darkTheme = false) {
        FillProfileInfoScreen(rememberNavController())
//        AddPhotoButton { }
    }
}



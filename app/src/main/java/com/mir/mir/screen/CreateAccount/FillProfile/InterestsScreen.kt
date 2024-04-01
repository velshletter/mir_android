package com.mir.mir.screen.CreateAccount.FillProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mir.mir.R
import com.mir.mir.screen.ButtonResume
import com.mir.mir.screen.HeaderLarge
import com.mir.mir.ui.theme.BackgroundBtn
import com.mir.mir.ui.theme.BackgroundBtnGrey
import com.mir.mir.ui.theme.MirTheme
import de.apuri.physicslayout.lib.BodyConfig
import de.apuri.physicslayout.lib.PhysicsLayout
import de.apuri.physicslayout.lib.physicsBody
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsScreen(
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
                    navController.navigate("TurnOnLocationScreen")
                }
            )

        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            InterestsPhysicsLayout()
        }
    }
}


@Composable
fun InterestsPhysicsLayout() {

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        HeaderLarge("Заполните Ваши интересы")
        //        Button(
//            modifier = Modifier,
//            onClick = {
//                items.put((items.size + 1).toString(), false)
//                Log.d("MyLog", items.size.toString())
//            },
//            content = {
//                Text("add")
//            }
//        )
//        PhysicsLayout(
//            modifier = Modifier.fillMaxSize(),
//            content = {
//                Card(
//                    modifier = Modifier
//                        .physicsBody(
//                            shape = CircleShape,
//                            bodyConfig = BodyConfig(
//                                angularDamping = 1f,
//                                restitution = 1f,
//                                density = 1.5f
//                            )
//                        ).align(Alignment.Center)
////                        .offset((-50).dp)
//                        .size(90.dp),
//                    colors = CardDefaults.cardColors(
//                        containerColor = Color.Black
//                    ),
//                    shape = CircleShape,
//                ) {}
//                items.value.forEach { (text, b) ->
//                    var isSelected by remember { mutableStateOf(b) }
//                    var size by remember { mutableStateOf(if (isSelected) 120.dp else 90.dp) }
//                    var color by remember { mutableStateOf(if (isSelected) BackgroundBtn else BackgroundBtnGrey) }
//                    LaunchedEffect(key1 = text) {
//                        delay(1000)
//                    }
//                    Card(
//                        modifier = Modifier
//                            .physicsBody(
//                                shape = CircleShape
//                            ).align(Alignment.TopCenter)
//                            .size(size)
//                            .clickable {
//                                isSelected = !isSelected
//                                size = if (isSelected) 120.dp else 90.dp
//                                color = if (isSelected) BackgroundBtn else BackgroundBtnGrey
//                                items.value.put(text, isSelected)
//                            },
//                        colors = CardDefaults.cardColors(
//                            containerColor = color
//                        ),
//                        shape = CircleShape,
//                    ) {
//                        Box(
//                            modifier = Modifier.fillMaxSize(),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                text = text,
//                                textAlign = TextAlign.Center,
//                                modifier = Modifier
//                                    .padding(8.dp)
//                            )
//                        }
//                    }
//                }
//            })
    }
}

//@Composable
//fun InterestBall(text: String, b: Boolean) {
//    var isSelected by remember { mutableStateOf(b) }
//    var size by remember { mutableStateOf(if (isSelected) 120.dp else 100.dp) }
//    var color by remember { mutableStateOf(if (isSelected) BackgroundBtn else BackgroundBtnGrey) }
//    LaunchedEffect(key1 = text) {
//        // Добавляем задержку в 100 миллисекунд между созданием каждого элемента
//        delay(1000)
//    }
//    Card(
//        modifier = Modifier
//            .physicsBody(
//                shape = CircleShape
//            )
//            .size(size)
//            .clickable {
//                isSelected = !isSelected
//                size = if (isSelected) 120.dp else 100.dp
//                color = if (isSelected) BackgroundBtn else BackgroundBtnGrey
//                items.value.put(text, isSelected)
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = color
//        ),
//        shape = CircleShape,
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = text,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .wrapContentHeight()
//            )
//        }
//    }
//}


val items =
    mutableStateOf(
        mutableStateMapOf<String, Boolean>(
            Pair("Собаки", false),
            Pair("Кошки", false),
            Pair("Техно", false),
            Pair("Хип-хоп", false),
            Pair("Пение", false),
            Pair("Тусовки и клубы", false),
            Pair("Трен.зал", false),
            Pair("Классическая музыка", false),
            Pair("Кофе", false),
            Pair("Рисование", false),
            Pair("Меломан", false),
            Pair("Чай", false),
            Pair("Вегетарианство", false),
            Pair("Фотография", false),
            Pair("Танцы", false),
            Pair("Рэп", false),
            Pair("Пицца", false),
            Pair("Театры", false),
            Pair("Поп-музыка", false),
            Pair("Компьютерные игры", false),
            Pair("Велосипед", false),
            Pair("Суши", false),
            Pair("Музыка", false),
            Pair("Бег", false),
            Pair("Настольные игры", false),
            Pair("Фитнес", false),
            Pair("Здоровая еда", false)
        )
    )

@Preview()
@Composable
fun InterestsPreview() {
    MirTheme(darkTheme = false) {
        InterestsScreen(rememberNavController(), viewModel())
    }
}

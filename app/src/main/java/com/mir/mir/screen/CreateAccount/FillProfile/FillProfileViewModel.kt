package com.mir.mir.screen.CreateAccount.FillProfile

import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FillProfileViewModel: ViewModel() {
    var nameState = mutableStateOf("")
    var birthDay = mutableStateOf("")
    var birthMounth = mutableStateOf("")
    var birthYear = mutableStateOf("")
    var sex =  mutableStateOf("Мужчина")
    var height = mutableStateOf("")
    var aboutYourself = mutableStateOf("")
    var selectImages = mutableStateOf(listOf<Uri>())

    var goals = mutableStateOf("Серьезные отношения")
    var alcohol = mutableStateOf("Пью часто")
    var smoking = mutableStateOf("Курю")
    var sport = mutableStateOf("Часто занимаюсь")

    var education = mutableStateOf("Высшее")
    var zodiac = mutableStateOf("Овен")
    var type = mutableStateOf("Экстраверт")

    var country = mutableStateOf("")
    var city = mutableStateOf("")
}
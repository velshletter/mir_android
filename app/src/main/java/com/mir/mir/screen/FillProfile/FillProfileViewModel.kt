package com.mir.mir.screen.FillProfile

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
}
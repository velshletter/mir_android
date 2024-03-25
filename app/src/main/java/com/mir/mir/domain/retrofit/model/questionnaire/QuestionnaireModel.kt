package com.mir.mir.domain.retrofit.model.questionnaire

data class QuestionnaireModel(
    val firstname: String,
    val lastname: String,
    val gender: String,
    val photo: String,
    val country: String,
    val city: String,
    val about: String,
    val hobbies: List<HobbyModel>,
    val height: Int,
    val goals: String,
    val bodyType: String,
    val age: Int
)

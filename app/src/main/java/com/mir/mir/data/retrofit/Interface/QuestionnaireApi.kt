package com.mir.mir.data.retrofit.Interface

import com.mir.mir.domain.retrofit.model.questionnaire.QuestionnaireModel
import retrofit2.http.Body
import retrofit2.http.POST

interface QuestionnaireApi {

    @POST("/api/v1/questionnaire")
    suspend fun createQuestionnaire(
        @Body questionnaireRequestBody: QuestionnaireModel
    ): QuestionnaireModel

    
}
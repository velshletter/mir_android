package com.mir.mir.data.retrofit.Interface

import com.mir.mir.domain.retrofit.model.user.ProfileRequestModel
import com.mir.mir.domain.retrofit.model.user.ProfileResponseModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH

interface UserApi {

    @GET("/api/v1/users/me")
    suspend fun getProfile(): ProfileResponseModel

    @PATCH("/api/v1/users/me")
    suspend fun updateProfile(
        @Body profileRequestBody: ProfileRequestModel
    ): ProfileResponseModel

}
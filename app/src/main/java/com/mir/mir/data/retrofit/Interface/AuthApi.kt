package com.mir.mir.data.retrofit.Interface


import com.mir.mir.domain.retrofit.model.auth.LoginRequest
import com.mir.mir.domain.retrofit.model.auth.RegisterRequest
import com.mir.mir.domain.retrofit.model.auth.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/v1/auth/login")
    suspend fun postAuthLogin(
        @Body loginRequest: LoginRequest
    )

    @POST("/api/v1/auth/register")
    suspend fun postAuthRegister(
        @Body registerRequest: RegisterRequest
    ): RegisterResponse

    @GET("/api/v1/auth/logout")
    suspend fun postAuthLogout()

}

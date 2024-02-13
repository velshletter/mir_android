package com.mir.mir.data.retrofit.repository

import com.mir.mir.data.retrofit.RetrofitInstance.authApi
import com.mir.mir.domain.retrofit.model.auth.LoginRequest
import com.mir.mir.domain.retrofit.model.auth.RegisterRequest
import com.mir.mir.domain.retrofit.model.auth.RegisterResponse

class AuthRepository {
    suspend fun login(loginRequest: LoginRequest) {
        authApi.postAuthLogin(loginRequest)
    }

    suspend fun logout(){
        authApi.postAuthLogout()
    }

    suspend fun register(registerRequest: RegisterRequest): RegisterResponse {
        return authApi.postAuthRegister(registerRequest)
    }
}
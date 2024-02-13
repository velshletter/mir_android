package com.mir.mir.domain.retrofit.usecases.auth

import com.mir.mir.data.retrofit.repository.AuthRepository
import com.mir.mir.domain.retrofit.model.auth.LoginRequest

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) {
        val loginRequest = LoginRequest(email = email, password = password)
        authRepository.login(loginRequest)
    }
}
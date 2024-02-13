package com.mir.mir.domain.retrofit.usecases.auth

import com.mir.mir.data.retrofit.repository.AuthRepository
import com.mir.mir.domain.retrofit.model.auth.RegisterRequest
import com.mir.mir.domain.retrofit.model.auth.RegisterResponse

class RegisterUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): RegisterResponse {
        val registerRequest = RegisterRequest(email = email, password = password)
        return authRepository.register(registerRequest)
    }
}
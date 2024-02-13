package com.mir.mir.domain.retrofit.usecases.auth

import com.mir.mir.data.retrofit.repository.AuthRepository

class LogoutUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(){
        authRepository.logout()
    }
}
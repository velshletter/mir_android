package com.mir.mir.domain.retrofit.usecases.user

import com.mir.mir.data.retrofit.repository.UserProfileRepository
import com.mir.mir.domain.retrofit.model.user.ProfileResponseModel

class GetProfileUseCase(private val userProfileRepository: UserProfileRepository) {
    suspend operator fun invoke(): ProfileResponseModel{
       return userProfileRepository.getProfile()
    }
}
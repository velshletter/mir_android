package com.mir.mir.domain.retrofit.usecases.user

import com.mir.mir.data.retrofit.repository.UserProfileRepository
import com.mir.mir.domain.retrofit.model.user.ProfileRequestModel
import com.mir.mir.domain.retrofit.model.user.ProfileResponseModel

class UpdateProfileUseCase(private val userProfileRepository: UserProfileRepository) {
    suspend operator fun invoke(
        searchRangeMin: Int, searchRangeMax: Int,
        searchAgeMin: Int, searchAgeMax: Int
    ): ProfileResponseModel {
        val profileRequestBody = ProfileRequestModel(search_range_min = searchRangeMin, search_range_max = searchRangeMax,
            search_age_min = searchAgeMin, search_age_max = searchAgeMax)
        return userProfileRepository.updateProfile(profileRequestBody)
    }
}
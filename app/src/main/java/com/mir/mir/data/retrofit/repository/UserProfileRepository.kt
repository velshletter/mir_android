package com.mir.mir.data.retrofit.repository

import com.mir.mir.data.retrofit.RetrofitInstance.userApi
import com.mir.mir.domain.retrofit.model.user.ProfileRequestModel
import com.mir.mir.domain.retrofit.model.user.ProfileResponseModel

class UserProfileRepository {

    suspend fun getProfile(): ProfileResponseModel{
        return userApi.getProfile()
    }

    suspend fun updateProfile(profileRequestBody: ProfileRequestModel): ProfileResponseModel{
        return userApi.updateProfile(profileRequestBody)
    }
}
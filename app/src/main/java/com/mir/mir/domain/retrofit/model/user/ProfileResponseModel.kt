package com.mir.mir.domain.retrofit.model.user

data class ProfileResponseModel(
    val search_range_min: Int,
    val search_range_max: Int,
    val search_age_min: Int,
    val search_age_max: Int,
    val id: String,
    val user_id: String,
    val subscriber: String
)

package com.mir.mir.domain.retrofit.model.user

data class ProfileRequestModel(
    val search_range_min: Int,
    val search_range_max: Int,
    val search_age_min: Int,
    val search_age_max: Int
)

package com.mir.mir.domain.retrofit.model.auth

data class RegisterResponse(
    val id: String,
    val email: String,
    val is_active: Boolean,
    val is_superuser: Boolean,
    val is_verified: Boolean
)
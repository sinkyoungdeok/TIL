package com.kdsin.userservice.model

data class SignUpRequest (
    val email: String,
    val password: String,
    val username: String,
)

data class SignInRequest(
    val email: String,
    val passowrd: String,
)

data class SignInResponse(
    val email: String,
    val username: String,
    val token: String,
)
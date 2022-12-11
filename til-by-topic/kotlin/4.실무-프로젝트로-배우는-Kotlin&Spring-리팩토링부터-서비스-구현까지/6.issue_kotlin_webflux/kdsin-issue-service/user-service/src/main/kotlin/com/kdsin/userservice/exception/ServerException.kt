package com.kdsin.userservice.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)

data class UserExistsException(
    override val message: String = "이미 존재하는 유저입니다"
) : ServerException(409, message)

data class UserNotFoundException(
    override val message: String = "유저가 존재하지 않습니다"
) : ServerException(404, message)

data class PasswordNotMatchedException(
    override val message: String = "패스워드가 잘못되었습니다"
) : ServerException(400, message)

data class InvalidJwtTokenException(
    override val message: String = "잘못된 토큰입니다"
) : ServerException(400, message)
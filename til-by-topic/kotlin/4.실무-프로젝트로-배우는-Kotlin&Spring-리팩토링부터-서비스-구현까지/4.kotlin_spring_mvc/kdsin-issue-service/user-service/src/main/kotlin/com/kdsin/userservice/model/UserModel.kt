package com.kdsin.userservice.model

import com.kdsin.userservice.domain.entity.User
import java.time.LocalDateTime

data class UserEditRequest(
    val username: String,
)

data class MeResponse(
    val id: Long,
    val profileUrl: String?,
    val username: String,
    val email: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) {

    companion object {

        operator fun invoke(user: User) = with(user) {
            MeResponse(
                id = id!!,
                profileUrl = if (profileUrl.isNullOrEmpty()) null else "http://localhost:9090/images/$profileUrl",
                username = username,
                email = email,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )

        }


    }
}
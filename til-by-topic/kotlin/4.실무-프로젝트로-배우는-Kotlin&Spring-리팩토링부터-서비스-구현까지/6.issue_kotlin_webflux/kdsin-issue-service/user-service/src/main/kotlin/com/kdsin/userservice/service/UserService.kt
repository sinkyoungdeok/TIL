package com.kdsin.userservice.service

import com.kdsin.userservice.domain.entity.User
import com.kdsin.userservice.domain.repository.UserRepository
import com.kdsin.userservice.exception.UserExistsException
import com.kdsin.userservice.model.SignUpRequest
import com.kdsin.userservice.utils.BCryptUtils
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository,
) {

    suspend fun signUp(signUpRequest: SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(email)?.let {
                throw UserExistsException()
            }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username,
            )
            userRepository.save(user)
        }
    }
}
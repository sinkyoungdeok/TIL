package com.kdsin.userservice.service

import com.kdsin.userservice.config.JWTProperties
import com.kdsin.userservice.domain.entity.User
import com.kdsin.userservice.domain.repository.UserRepository
import com.kdsin.userservice.exception.PasswordNotMatchedException
import com.kdsin.userservice.exception.UserExistsException
import com.kdsin.userservice.exception.UserNotFoundException
import com.kdsin.userservice.model.SignInRequest
import com.kdsin.userservice.model.SignInResponse
import com.kdsin.userservice.model.SignUpRequest
import com.kdsin.userservice.utils.BCryptUtils
import com.kdsin.userservice.utils.JWTClaim
import com.kdsin.userservice.utils.JWTUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService (
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {

    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }
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

    suspend fun signIn(signInRequest: SignInRequest): SignInResponse {
        return with(userRepository.findByEmail(signInRequest.email) ?: throw UserNotFoundException()) {
            val verified = BCryptUtils.verify(signInRequest.passowrd, password)
            if (!verified) {
                throw PasswordNotMatchedException()
            }

            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username,
            )

            val token = JWTUtils.createToken(jwtClaim, jwtProperties)

            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)

            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token: String) {
        cacheManager.awaitEvict(token)
    }

    suspend fun get(userId: Long): User {
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }
}
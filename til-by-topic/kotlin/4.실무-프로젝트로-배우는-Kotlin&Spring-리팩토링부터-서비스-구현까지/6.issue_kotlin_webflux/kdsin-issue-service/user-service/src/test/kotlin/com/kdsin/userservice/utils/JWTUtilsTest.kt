package com.kdsin.userservice.utils

import com.kdsin.userservice.config.JWTProperties
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class JWTUtilsTest {

    private val logger = KotlinLogging.logger {}

    @Test
    fun createTokenTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gamil.com",
            profileUrl = "profile.jpg",
            username = "개발자"
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret",
        )
        val token = JWTUtils.createToken(jwtClaim, properties)

        assertNotNull(token)

        logger.info { "token : $token" }
    }

    @Test
    fun decodeTest() {
        val jwtClaim = JWTClaim(
            userId = 1,
            email = "dev@gamil.com",
            profileUrl = "profile.jpg",
            username = "개발자"
        )

        val properties = JWTProperties(
            issuer = "jara",
            subject = "auth",
            expiresTime = 3600,
            secret = "my-secret",
        )
        val token = JWTUtils.createToken(jwtClaim, properties)

        val decode = JWTUtils.decode(token, secret = properties.secret, issuer = properties.issuer)

        with(decode) {
            logger.info { "claims : $claims" }

            val userId = claims["userId"]!!.asLong()
            assertEquals(userId, jwtClaim.userId)

            val profileUrl = claims["profileUrl"]?.asString()
            assertEquals(profileUrl, jwtClaim.profileUrl)

            val username = claims["username"]!!.asString()
            assertEquals(username, jwtClaim.username)

            val email = claims["email"]!!.asString()
            assertEquals(email, jwtClaim.email)
        }
    }
}
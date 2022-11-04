package com.kdsin.userservice.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.kdsin.userservice.config.JWTProperties
import java.util.*

object JWTUtils {

    fun createToken(claim: JWTClaim, properties: JWTProperties) =
        JWT.create()
            .withIssuer(properties.issuer)
            .withSubject(properties.subject)
            .withIssuedAt(Date())
            .withExpiresAt(Date(Date().time + properties.expiresTime * 1000))
            .withClaim("userId", claim.userId)
            .withClaim("email", claim.email)
            .withClaim("profileUrl", claim.profileUrl)
            .withClaim("username", claim.username)
            .sign(Algorithm.HMAC256(properties.secret))

    fun decode(token: String, secret: String, issuer: String): DecodedJWT {
        val algorithm = Algorithm.HMAC256(secret)

        val verifier = JWT.require(algorithm)
            .withIssuer(issuer)
            .build()

        return verifier.verify(token)
    }

}

data class JWTClaim(
    val userId: Long,
    val email: String,
    val profileUrl: String? = null,
    val username: String,
)
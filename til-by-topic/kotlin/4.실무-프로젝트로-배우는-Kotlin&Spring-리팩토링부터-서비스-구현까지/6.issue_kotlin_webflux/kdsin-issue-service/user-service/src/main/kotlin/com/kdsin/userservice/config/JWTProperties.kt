package com.kdsin.userservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class JWTProperties (
    val issuer: String,
    val subject: String,
    val expiresTime: Long,
    val secret: String,
)
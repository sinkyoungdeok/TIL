package com.kdsin.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class KdSinUserServiceApplication

fun main(args: Array<String>) {
    runApplication<KdSinUserServiceApplication>(*args)
}
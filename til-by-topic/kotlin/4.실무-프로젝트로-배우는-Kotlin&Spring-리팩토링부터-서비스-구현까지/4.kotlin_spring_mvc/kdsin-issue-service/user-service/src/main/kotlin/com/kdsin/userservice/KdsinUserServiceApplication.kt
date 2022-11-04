package com.kdsin.userservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class kdsinUserServiceApplication

fun main(args: Array<String>) {
    runApplication<kdsinUserServiceApplication>(*args)
}
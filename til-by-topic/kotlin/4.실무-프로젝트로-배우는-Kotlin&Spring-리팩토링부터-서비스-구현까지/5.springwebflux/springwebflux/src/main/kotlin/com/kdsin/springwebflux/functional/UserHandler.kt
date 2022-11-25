package com.kdsin.springwebflux.functional

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

data class User(val id: Long, val email: String)

@Component
class UserHandler {

    val users = listOf(
        User(id = 1, email = "user1@gmail.com"),
        User(id = 2, email = "user2@gmail.com"),
    )

    fun getUser(req: ServerRequest): Mono<ServerResponse> =
        users.find { req.pathVariable("id").toLong() == it.id }
            ?.let {
                ServerResponse.ok().bodyValue(it)
            } ?: ServerResponse.notFound().build()

    fun getAll(req: ServerRequest): Mono<ServerResponse> =
        ServerResponse.ok().bodyValue(users)
}

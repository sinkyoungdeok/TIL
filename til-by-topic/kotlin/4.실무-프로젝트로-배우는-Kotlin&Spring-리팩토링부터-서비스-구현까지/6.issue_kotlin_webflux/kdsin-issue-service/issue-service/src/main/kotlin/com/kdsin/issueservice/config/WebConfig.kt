package com.kdsin.issueservice.config

import com.fasterxml.jackson.annotation.JsonProperty
import com.kdsin.issueservice.exception.UnauthorizedException
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class WebConfig(
    private val authUserHandlerArgumentResolver: AuthUserHandlerArgumentResolver,
) : WebMvcConfigurationSupport() {


    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {
        argumentResolvers.apply {
            add(authUserHandlerArgumentResolver)
        }
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(*arrayOf(
                "classpath:/META-INF/resources/",
                "classpath:/resources/",
                "classpath:/static/",
                "classpath:/public/"
            ))
    }
}

@Component
class AuthUserHandlerArgumentResolver(
    @Value("\${auth.url}") val authUrl: String,
) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean =
        AuthUser::class.java.isAssignableFrom(parameter.parameterType)

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?
    ): Any? {

        val authHeader = webRequest.getHeader("Authorization") ?: throw UnauthorizedException()

        return runBlocking {
            WebClient.create()
                .get()
                .uri(authUrl)
                .header("Authorization", authHeader) // Bearer asdasd.adaa.awww.
                .retrieve()
                .awaitBody<AuthUser>()
        }
    }


}

data class AuthUser(
    @JsonProperty("id")
    val userId: Long,
    val username: String,
    val email: String,
    val profileUrl: String? = null,
)


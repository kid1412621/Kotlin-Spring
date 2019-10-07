package com.example.demo.controller

import com.example.demo.dao.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED
import org.springframework.stereotype.Controller
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class WebConfig(private val userHandler: UserHandler) : WebFluxConfigurer {

    @Bean
    fun routerFunctionUser(): RouterFunction<*> {
//        return coRouter {
        return router {
            (accept(APPLICATION_FORM_URLENCODED) and "/lambda").nest {
                GET("/ok") { ok().bodyValue("ok!\t\n") }
                POST("/user") { req -> userHandler.getUserById(req) }
            }
        }
    }

}

@Controller
class UserHandler(private val repository: UserRepository) {
    //suspend
    fun getUserById(req: ServerRequest): Mono<ServerResponse> {
        var user = repository.findById(req.queryParam("id").get().toLong())
        return ok().bodyValue(user)
    }

}

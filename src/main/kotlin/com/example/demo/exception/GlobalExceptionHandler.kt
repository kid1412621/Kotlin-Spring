package com.example.demo.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@ControllerAdvice
class GlobalExceptionHandler {
    /**
     * handle app exception
     */
    @ExceptionHandler(ApplicationException::class)
    fun handleApplicationException(ex: Exception): Mono<ServerResponse> {
        // do something
        return ok().build()
    }

    /**
     * handle other exception
     */
    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): Mono<ServerResponse> {
        ex.printStackTrace()
        // do something
        return ok().build()
    }
}

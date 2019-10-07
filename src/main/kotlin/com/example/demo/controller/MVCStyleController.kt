package com.example.demo.controller

import com.example.demo.dao.UserRepository
import com.example.demo.entity.TUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono


// won't work due to using functional endpoints and missing some adaptable configures
@RestController
@RequestMapping("/mvc")
class MVCStyleController
@Autowired constructor(val userRepository: UserRepository) {

    @GetMapping("/ok")
    fun ok(name: String?): Mono<String> =
            Mono.just("ok! ${name ?: "nobody"}\t\n")


    @PostMapping("/userByEmail")
    fun getUserByEmail(@RequestParam email: String): TUser? {
        return userRepository.findByEmail(email)
    }

}
package com.example.demo.dao

import com.example.demo.entity.TUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface UserRepository : JpaRepository<TUser, Long>, JpaSpecificationExecutor<TUser> {
    fun findByEmail(email: String): TUser?

    @Query("SELECT u FROM TUser u WHERE LOWER(u.username) = LOWER(:username)")
    fun retrieveByUsername(@Param("username") username: String): TUser?

}
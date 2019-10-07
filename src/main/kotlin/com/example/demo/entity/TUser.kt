package com.example.demo.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.sql.Timestamp
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "t_user", schema = "demo")
data class TUser(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var gender: Int? = null,
        var username: String? = null,
        var mobile: String? = null,
        var email: String? = null,
        @CreatedDate
        var createTime: Timestamp? = null,
        @LastModifiedDate //  jpa auditing
        @Temporal(TemporalType.TIMESTAMP)// mapping SQL date type
        var updateTime: Date? = null
) : Serializable

package com.kdsin.userservice.domain.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("users")
data class User (

    @Id
    val id : Long? = null,

    @Column
    val email: String,

    @Column
    val password: String,

    @Column
    val username: String,

    @Column
    val profileUrl: String? = null,

    @CreatedDate
    @Column("created_at")
    val createdAt: LocalDateTime?=null,

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: LocalDateTime?= null,

)
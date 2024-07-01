package com.example.intex.domain.model

import com.example.intex.data.data_source.UserEntity

data class User (
    val userId: Int?=0,
    val name: String? = null
){
    fun toEntity(): UserEntity {
        return UserEntity(
            id = userId,
            name = name
        )
    }
}


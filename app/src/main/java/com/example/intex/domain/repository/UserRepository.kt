package com.example.intex.domain.repository

import com.example.intex.domain.model.User

interface UserRepository {

    suspend fun saveUser(user: User)
    suspend fun deleteUser(user: User)
    suspend fun getUser(userName: String): User

}
package com.example.intex.data.repository

import com.example.intex.data.data_source.IntExDatabase
import com.example.intex.domain.model.User
import com.example.intex.domain.repository.UserRepository
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor( private val db: IntExDatabase) : UserRepository {

    override suspend fun saveUser(user: User) {
        db.userDao.insertUser(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        db.userDao.deleteUser(user.toEntity())
    }

    override suspend fun getUser(userName: String): User {
       return db.userDao.getUser(userName).toUser()
    }
}
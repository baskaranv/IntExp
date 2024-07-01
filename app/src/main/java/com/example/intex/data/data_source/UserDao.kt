package com.example.intex.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.intex.domain.model.User

@Dao
interface UserDao {

    @Upsert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("Select * from userentity where name = :userName")
    suspend fun getUser(userName: String) : UserEntity

    @Delete
    suspend fun deleteUser(user: UserEntity)


}
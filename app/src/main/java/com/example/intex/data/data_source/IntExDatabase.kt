package com.example.intex.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class,QuestionEntity::class], version = 1)
abstract class IntExDatabase : RoomDatabase(){
    abstract val userDao : UserDao
    abstract val questionDao: QuestionDao
}
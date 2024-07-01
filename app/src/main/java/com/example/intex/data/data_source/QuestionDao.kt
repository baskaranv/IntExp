package com.example.intex.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(questionEntity: QuestionEntity) : Long

    @Query("select * from questionentity")
    suspend fun getQuestionList() : List<QuestionEntity>

    @Delete
    suspend fun deleteQuestion(questionEntity: QuestionEntity) : Int
}
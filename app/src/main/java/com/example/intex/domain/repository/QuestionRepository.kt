package com.example.intex.domain.repository

import com.example.intex.domain.model.Question

interface QuestionRepository {
    suspend fun saveQuestion(question: Question) : Long
    suspend fun getQuestionList() : List<Question>
    suspend fun deleteQuestion(question: Question) : Int
}
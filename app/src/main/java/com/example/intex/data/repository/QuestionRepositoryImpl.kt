package com.example.intex.data.repository

import com.example.intex.data.data_source.IntExDatabase
import com.example.intex.domain.model.Question
import com.example.intex.domain.repository.QuestionRepository
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(private val db: IntExDatabase) : QuestionRepository {
    override suspend fun saveQuestion(question: Question) : Long {
        return db.questionDao.insertQuestion(question.toEntity())
    }

    override suspend fun getQuestionList(): List<Question> {
        return db.questionDao.getQuestionList().map{it.toQuestion()}
    }

    override suspend fun deleteQuestion(question: Question) : Int {
       return db.questionDao.deleteQuestion(question.toEntity())
    }
}
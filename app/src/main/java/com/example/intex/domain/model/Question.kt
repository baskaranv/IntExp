package com.example.intex.domain.model

import com.example.intex.data.data_source.QuestionEntity
import com.example.intex.domain.util.Domain

data class Question(
    var id: Int =0,
    var question: String? =null,
    var domain: Domain? =null

){
    fun toEntity() : QuestionEntity {
        return QuestionEntity(
            id = id,
            question = question,
            domain = domain
        )
    }
}
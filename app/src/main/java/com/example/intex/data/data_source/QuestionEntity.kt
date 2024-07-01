package com.example.intex.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.intex.domain.model.Question
import com.example.intex.domain.util.Domain

@Entity
data class QuestionEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var question: String? = null,
    val domain: Domain? =null
){
    fun toQuestion() : Question{
        return Question(
            id =id,
            question = question,
            domain = domain
        )
    }
}

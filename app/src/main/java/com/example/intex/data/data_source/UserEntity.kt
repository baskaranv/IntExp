package com.example.intex.data.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.intex.domain.model.User

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int? =null,
    var name: String? =null
){
    fun toUser() = User(
        userId = id,
        name = name
    )
}
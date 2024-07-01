package com.example.intex.di

import android.content.Context
import androidx.room.Room
import com.example.intex.data.data_source.IntExDatabase
import com.example.intex.data.repository.QuestionRepositoryImpl
import com.example.intex.data.repository.UserRepositoryImpl
import com.example.intex.domain.repository.QuestionRepository
import com.example.intex.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRoomDB(@ApplicationContext context: Context) : IntExDatabase{
        return Room.databaseBuilder(
            context,IntExDatabase::class.java,"int_ex_app")
            .build()
    }

    @Provides
    fun providesUserRepo(db: IntExDatabase): UserRepository{
        return UserRepositoryImpl(db)
    }

    @Provides
    fun providesQuestionRepo(db: IntExDatabase) : QuestionRepository{
        return QuestionRepositoryImpl(db)
    }


}
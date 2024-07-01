package com.example.intex.data.data_source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.intex.domain.util.Domain
import com.google.common.truth.ExpectFailure
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class QuestionDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: IntExDatabase
    private lateinit var dao: QuestionDao

    @Before
    fun setUp(){

        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                IntExDatabase::class.java
        ).build()

        dao = database.questionDao
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertQuestion() =  runBlocking {

        val questionEntity = QuestionEntity(1," Question One", Domain.ANDROID)
        dao.insertQuestion(questionEntity)

        val resultQuestion = dao.getQuestionList()

        assertThat(resultQuestion).contains(questionEntity)

    }

    @Test
    fun getQList() = runBlocking {

        val questionEntityOne = QuestionEntity(1," Question One", Domain.ANDROID)
        val questionEntityTwo = QuestionEntity(2," Question Tow", Domain.ANDROID)
        val questionEntityThree = QuestionEntity(3," Question Three", Domain.ANDROID)

        dao.insertQuestion(questionEntityOne)
        dao.insertQuestion(questionEntityTwo)
        dao.insertQuestion(questionEntityThree)
        val myQuestionList = listOf(questionEntityOne,questionEntityTwo,questionEntityThree)
        val resultQuestion = dao.getQuestionList()
        assertThat(resultQuestion).contains(questionEntityOne)

    }

    @Test
    fun deleteQuestion() = runBlocking {
        val questionEntityOne = QuestionEntity(1," Question One", Domain.ANDROID)
        dao.insertQuestion(questionEntityOne)

        dao.deleteQuestion(questionEntityOne)

        val questionEntity = dao.getQuestionList()

        assertThat(questionEntity).doesNotContain(questionEntity)

    }




}
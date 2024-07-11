package com.example.intex.presentation.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.intex.data.repository.FakeUserRepositoryImpl
import com.example.intex.getOrAwaitValueTest
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


class LoginViewModelTest @Inject constructor(

) {

    @get :Rule
    var instantTaskExecutorRule  = InstantTaskExecutorRule()


    private lateinit var viewModel : LoginViewModel

    @Before
    fun setup(){
        viewModel = LoginViewModel(FakeUserRepositoryImpl())
    }

    @Test
    fun `empty user name, return error`() {

        viewModel.validateUser("","asdf")
        val result = viewModel.loginResult.getOrAwaitValueTest()
        assertThat(result).isEqualTo("Invalid user Name")

    }

    @Test
    fun `empty password, return error()`(){
        viewModel.validateUser("admin@gmail.com","")
        val result = viewModel.loginResult.getOrAwaitValueTest()
        assertThat(result).isEqualTo("Invalid password")
    }

    @Test
    fun `wrong user and password, return error`(){
        viewModel.validateUser("test@yopmail.com","admin@123")
        val result = viewModel.loginResult.getOrAwaitValueTest()
        assertThat(result).isEqualTo("Invalid username or password")

    }
    @Test
    fun `correct user name and password, return success`(){
        viewModel.validateUser("admin@gmail.com","admin")
        val result = viewModel.loginResult.getOrAwaitValueTest()
        assertThat(result).isEqualTo("Success")
    }


}
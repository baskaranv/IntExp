package com.example.intex.presentation.login

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.intex.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var scenario: ActivityScenario<LoginActivity>

    @Before
    fun setUp() {
        scenario = ActivityScenario.launch(LoginActivity::class.java)
        scenario.moveToState(Lifecycle.State.RESUMED)

    }

    @Test
    fun testLogin(){
        val userName = "admin@gmail.com"
        val password = "admin"
        onView(withId(R.id.edt_user_name)).perform(ViewActions.typeText(userName.toString()))
        onView(withId(R.id.edt_txt_password)).perform(ViewActions.typeText(password.toString()))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_login)).perform(click())

    }


}

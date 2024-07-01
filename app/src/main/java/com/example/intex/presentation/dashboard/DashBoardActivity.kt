package com.example.intex.presentation.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.intex.R
import com.example.intex.databinding.ActivityDashBoardBinding
import com.example.intex.domain.model.Question
import com.example.intex.domain.util.Domain
import com.example.intex.presentation.questionlist.QuestionActivity
import com.example.intex.presentation.questionlist.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardActivity : AppCompatActivity() {
    private val viewModel: QuestionViewModel by viewModels()
    private lateinit var binding: ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dash_board)

        binding.btn1.setOnClickListener {
            goToQuestionScreen()
        }
        binding.btn2.setOnClickListener {
            goToQuestionScreen()
        }
        /*viewModel.saveQuestion(Question(null,"Question one", Domain.ANDROID))
        viewModel.saveQuestion(Question(null,"Question two",Domain.ANDROID))*/

    }

    private fun goToQuestionScreen(){
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }

}
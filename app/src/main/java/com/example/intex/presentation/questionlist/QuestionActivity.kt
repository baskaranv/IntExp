package com.example.intex.presentation.questionlist

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intex.R
import com.example.intex.databinding.ActivityQuestionBinding
import com.example.intex.domain.model.Question
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class QuestionActivity : AppCompatActivity(), QuestionAdapter.QuestionListener,NewQuestionDialog.AddQuestion {
    private val viewModel: QuestionViewModel by viewModels()
    private lateinit var questionAdapter: QuestionAdapter
    private lateinit var dataBinding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_question)
        initRecyclerView()
        dataBinding.floatingActionButton.setOnClickListener {
            val questionDialog = NewQuestionDialog(this, this)
            questionDialog.show()
        }
        viewModel.getQList()
        setQuestionObserver()
    }

    private fun setQuestionObserver() {
        viewModel.questionList.observe(this){
           questionList ->
            questionList.forEach {
                println(" The question is $it")
            }
            questionAdapter.setUpQuestionList(ArrayList(questionList))
        }

        viewModel.saveResponse.observe(this){
           result ->
            viewModel.getQList()
        }

        viewModel.deleteResponse.observe(this){
            result ->
            viewModel.getQList()
        }
    }

    private fun initRecyclerView() {
        questionAdapter = QuestionAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        dataBinding.recyclerview.layoutManager = layoutManager
        dataBinding.recyclerview.setHasFixedSize(true)
        dataBinding.recyclerview.adapter = questionAdapter
    }

    override fun onQuestionClicked(question: Question) {
        Toast.makeText(this,question.question,Toast.LENGTH_SHORT).show()
    }

    override fun onQuestionDelete(question: Question) {
        viewModel.deleteQuestion(question)
        Toast.makeText(this, question.question + " Deleted",Toast.LENGTH_SHORT).show()

    }

    override fun addNewQuestion(question: Question) {
            viewModel.saveQuestion(question)
    }
}
package com.example.intex.presentation.questionlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intex.domain.model.Question
import com.example.intex.domain.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val repository: QuestionRepository): ViewModel() {

    private val _questionList: MutableLiveData<List<Question>> = MutableLiveData<List<Question>>()
    val questionList : LiveData<List<Question>> get() = _questionList

    private val _saveResponse: MutableLiveData<Boolean> = MutableLiveData(false)
    val saveResponse: LiveData<Boolean> get() = _saveResponse

    private val _deleteResponse: MutableLiveData<Int> = MutableLiveData(0)
    val deleteResponse: LiveData<Int> get() = _deleteResponse

    fun saveQuestion(question: Question){
        viewModelScope.launch(Dispatchers.IO) {
            val result = repository.saveQuestion(question)
            println(" The save result is $result")
            if(result!=0L){
                _saveResponse.postValue(true)
            }

        }
    }

    fun getQList() {
        viewModelScope.launch(Dispatchers.IO) {
           val result =  repository.getQuestionList()
            result.forEach {
                println(" The question is ${it.question}")
            }
            _questionList.postValue(result)
        }
    }



    fun deleteQuestion(question: Question){
        viewModelScope.launch(Dispatchers.IO) {
          val result =  repository.deleteQuestion(question)
            _deleteResponse.postValue(result)
        }
    }
}
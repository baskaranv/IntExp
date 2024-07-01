package com.example.intex.presentation.questionlist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.intex.databinding.QuestionItemRowBinding
import com.example.intex.domain.model.Question

class QuestionAdapter(private val listener: QuestionAdapter.QuestionListener) : RecyclerView.Adapter<ViewHolder>() {

    private var questionList = ArrayList<Question>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        return ViewHolder(QuestionItemRowBinding.inflate(inflater,parent,false))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUpQuestionList (qList: ArrayList<Question>){
        questionList.clear()
        questionList.addAll(qList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder){
                is  ViewHolder -> holder.bind(questionList[position])
            }
    }

    inner class ViewHolder(private val binding: QuestionItemRowBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: Question){
            with(binding){
                binding.item = item
                println(" The value printed in rv ${item.question}")
                binding.txtQuestion.text = item.question
                binding.txtQuestion.setOnClickListener {
                    listener.onQuestionClicked(item)
                }

                binding.imgDelete.setOnClickListener {
                    listener.onQuestionDelete(item)
                }

            }
        }
    }

   interface QuestionListener{
       fun onQuestionClicked(question: Question)
       fun onQuestionDelete(question: Question)
   }

}
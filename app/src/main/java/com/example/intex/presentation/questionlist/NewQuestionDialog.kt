package com.example.intex.presentation.questionlist

import android.app.ActionBar
import android.app.Dialog
import android.app.Notification.Action
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.intex.R
import com.example.intex.domain.model.Question
import com.example.intex.domain.util.Domain

class NewQuestionDialog(private val listener: AddQuestion, context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setContentView(R.layout.new_question)
        setCancelable(false)
        setCanceledOnTouchOutside(false)

        val window = window
        window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.WRAP_CONTENT)

        val edtText = findViewById<EditText>(R.id.edt_question)
        val addButton = findViewById<Button>(R.id.btn_add)
        val cancelButton = findViewById<Button>(R.id.btn_cancel)
        addButton.setOnClickListener {
            val question = edtText.text.toString()
            if(question.trim() != ""){
                this.listener.addNewQuestion(Question(0,question,Domain.ANDROID))
                dismiss()
            }
        }
        cancelButton.setOnClickListener {
            dismiss()
        }
    }


    interface AddQuestion{
        fun addNewQuestion(question: Question)
    }

}
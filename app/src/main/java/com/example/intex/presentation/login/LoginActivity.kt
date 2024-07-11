package com.example.intex.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.intex.R
import com.example.intex.databinding.ActivityLoginBinding
import com.example.intex.presentation.dashboard.DashBoardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityLoginBinding
    private val viewModel:LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
       // dataBinding.edtUserName.setText("admin@gmail.com")
      //  dataBinding.edtTxtPassword.setText("admin")
        dataBinding.btnLogin.setOnClickListener {
            val userName = dataBinding.edtUserName.text.toString()
            val password = dataBinding.edtTxtPassword.text.toString()
            viewModel.validateUser(userName, password)
        }
      //  dataBinding.btnLogin.callOnClick()
        viewModel.loginResult.observe(this) { result ->
            when (result) {
                "Success" ->
                    goToDashBoardPage()
                else -> {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun goToDashBoardPage() {
        val intent = Intent(this, DashBoardActivity::class.java)
        startActivity(intent)
        finish()
    }

}
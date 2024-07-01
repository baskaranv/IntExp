package com.example.intex.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intex.domain.model.User
import com.example.intex.domain.repository.UserRepository
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject  constructor(
    private val repo: UserRepository
) : ViewModel() {

    private var _loginResult: MutableLiveData<String> = MutableLiveData()
    val loginResult: LiveData<String> get() = _loginResult

    private var _user: MutableLiveData<User> = MutableLiveData()
    val user: LiveData<User> get() = _user

    fun validateUser(email: String, password: String){
        if(email.isEmpty()){
            _loginResult.postValue("Invalid user Name")
            return
        }
        if(password.isEmpty()){
            _loginResult.postValue("Invalid password")
            return

        }
        if(email != "admin@gmail.com" && password != "admin"){
            _loginResult.postValue("Invalid username or password")
            return
        }
        _loginResult.postValue("Success")
    }

    fun saveUser(user : User){
        viewModelScope.launch(Dispatchers.IO) {
            repo.saveUser(user)
        }
    }

    fun getUser(userName: String){
        viewModelScope.launch(Dispatchers.IO) {
            val result  = repo.getUser(userName)
            _user.postValue(result)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteUser(user)
        }
    }

}
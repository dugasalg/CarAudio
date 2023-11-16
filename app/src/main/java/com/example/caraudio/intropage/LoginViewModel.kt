package com.example.caraudio.intropage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.intropage.network.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() {
    private val repository = LoginRepository()

    private val _loginResponse = MutableLiveData<LoginModel>()
    val loginResponse: LiveData<LoginModel> = _loginResponse

    fun doLogin(loginData: LoginDataBody) {
        viewModelScope.launch {
            try {
                val loginResponse = repository.doLogin(loginData)
                _loginResponse.value = loginResponse
            } catch (e: Exception) {
                // Handle error
                Log.d("LoginViewModel", "Error: ${e.message}")
            }
        }
    }
}
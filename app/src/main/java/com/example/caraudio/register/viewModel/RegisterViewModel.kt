package com.example.caraudio.register.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.caraudio.register.model.RegisterDataBody
import com.example.caraudio.register.model.RegisterModel
import com.example.caraudio.register.network.RegisterRepository
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {
    private val repository = RegisterRepository()
    private val _isRegisterSuccessful = MutableLiveData<Boolean>()
    val isRegisterSuccessful: LiveData<Boolean> = _isRegisterSuccessful
    private val _registerResponse = MutableLiveData<RegisterModel>()
    val registerResponse: LiveData<RegisterModel> = _registerResponse
    private val _registerAttempted = MutableLiveData<Boolean>()
    val registerAttempted: LiveData<Boolean> = _registerAttempted

    fun doRegister(registerData: RegisterDataBody) {
        _registerAttempted.value = true

        viewModelScope.launch {
            try {
                val registerResponse = repository.doRegister(registerData)
                _registerResponse.value = registerResponse
                if ( registerResponse.message == "Usuario registrado correctamente" ) {
                    _isRegisterSuccessful.value = true
                    Log.d("RegisterViewModel", "Register successful")
                } else {
                    _isRegisterSuccessful.value = false
                    Log.d("RegisterViewModel", "Register unsuccessful")
                }
            } catch (e: Exception) {
                // Handle error
                Log.d("RegisterViewModel", "Error: ${e.message}")
                _isRegisterSuccessful.value = false
            }
        }
    }
}
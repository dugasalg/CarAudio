package com.example.caraudio.register.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.register.model.RegisterDataBody
import com.example.caraudio.register.model.RegisterModel


class RegisterRepository {
    private val registerService = RetrofitInstance.registerService

    suspend fun doRegister(registerData: RegisterDataBody): RegisterModel {
        return registerService.doRegister(registerData)
    }
}
package com.example.caraudio.register.network

import com.example.caraudio.intropage.Model.LoginDataBody
import com.example.caraudio.intropage.Model.LoginModel
import com.example.caraudio.register.model.RegisterDataBody
import com.example.caraudio.register.model.RegisterModel
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterService {
    @POST("users/registrar")
    suspend fun doRegister(@Body registerData: RegisterDataBody): RegisterModel
}
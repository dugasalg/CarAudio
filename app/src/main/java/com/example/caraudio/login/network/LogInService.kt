package com.example.caraudio.login.network

import com.example.caraudio.intropage.Model.LoginDataBody
import com.example.caraudio.intropage.Model.LoginModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    suspend fun doLogin(@Body loginData: LoginDataBody): LoginModel
}
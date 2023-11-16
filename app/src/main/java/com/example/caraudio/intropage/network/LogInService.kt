package com.example.caraudio.intropage.network

import com.example.caraudio.intropage.LoginDataBody
import com.example.caraudio.intropage.LoginModel
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/iniciar-sesion")
    suspend fun doLogin(@Body loginData: LoginDataBody): LoginModel
}
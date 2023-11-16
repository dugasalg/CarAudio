package com.example.caraudio.intropage.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.intropage.LoginDataBody
import com.example.caraudio.intropage.LoginModel

class LoginRepository {
    private val loginService = RetrofitInstance.loginService

    suspend fun doLogin(loginData: LoginDataBody): LoginModel {

        return loginService.doLogin(loginData)
    }
}
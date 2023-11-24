package com.example.caraudio.intropage.network

import com.example.caraudio.RetrofitInstance
import com.example.caraudio.intropage.Model.LoginDataBody
import com.example.caraudio.intropage.Model.LoginModel

class LoginRepository {
    private val loginService = RetrofitInstance.loginService

    suspend fun doLogin(loginData: LoginDataBody): LoginModel {

        return loginService.doLogin(loginData)
    }
}
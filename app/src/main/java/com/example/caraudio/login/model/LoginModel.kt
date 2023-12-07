package com.example.caraudio.intropage.Model

//Respuesta de nuestro servivio
data class LoginModel(
    val message: String,
    val jwt: String
)

//Se envia en el body de la peticion
data class LoginDataBody(
    val usrn: String,
    val password: String,
)
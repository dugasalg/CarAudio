package com.example.caraudio.intropage

//Respuesta de nuestro servivio
data class LoginModel(
    val message: String
)

//Se envia en el body de la peticion
data class LoginDataBody(
    val usrn: String,
    val password: String
)
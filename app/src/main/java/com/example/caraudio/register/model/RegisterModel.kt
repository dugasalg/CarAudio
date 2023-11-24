package com.example.caraudio.register.model

data class RegisterModel(
    val message: String,
    val obj: UserDetail
)

data class UserDetail(
    val username: String,
    val password: String,
    val birthDate: String,
    val address: String,
    val _id: String,
    val __v: Int
)

//Se envia en el body de la peticion
data class RegisterDataBody(
    val usrn: String,
    val password: String,
    val birthDate: String,
    val address: String
)
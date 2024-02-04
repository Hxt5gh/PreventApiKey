package com.example.validform.form_valid

data class FormState(
    val name : String = "" ,
    val nameError : String? = null ,

    val email : String = "" ,
    val emailError : String? = null,

    val password : String = "",
    val passwordError: String? = null,

    val repeatPassword : String = "",
    val repeatPasswordError : String? =  null
)

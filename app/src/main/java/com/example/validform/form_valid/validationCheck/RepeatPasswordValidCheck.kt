package com.example.validform.form_valid.validationCheck

import com.example.validform.form_valid.ValidationResult

class RepeatPasswordValidCheck {

    fun execute(password : String , repeatPassword : String): ValidationResult {
        if (password != repeatPassword)
        {
            return ValidationResult(
                successState = false,
                errorMessage = "password should match"
            )
        }
        return ValidationResult(
            successState = true
        )
    }

}
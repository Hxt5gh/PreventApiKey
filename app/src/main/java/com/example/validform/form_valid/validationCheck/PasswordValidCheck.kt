package com.example.validform.form_valid.validationCheck

import com.example.validform.form_valid.ValidationResult

class PasswordValidCheck {

    fun execute(password : String): ValidationResult {
        if (password.isBlank())
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Enter Password"
            )
        }

        if (password.length < 8)
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Password should be minimum 8 character long"
            )
        }

        val valid = password.any{  it.isLetter()} && password.any { it.isDigit() }
        if (!valid)
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Password should be contain atleast one digit or letter"
            )
        }

        return ValidationResult(
            successState = true
        )
    }

}
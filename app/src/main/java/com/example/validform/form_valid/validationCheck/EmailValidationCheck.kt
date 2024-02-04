package com.example.validform.form_valid.validationCheck

import android.util.Patterns
import com.example.validform.form_valid.ValidationResult


class EmailValidationCheck {

    fun execute(email : String) : ValidationResult
    {
        if (email.isBlank())
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Email Cant Be Empty"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Not a Valid Email"
            )
        }

        return ValidationResult(
            successState = true
        )

    }
}
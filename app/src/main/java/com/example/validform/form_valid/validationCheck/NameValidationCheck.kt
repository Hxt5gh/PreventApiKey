package com.example.validform.form_valid.validationCheck

import com.example.validform.form_valid.ValidationResult

class NameValidationCheck {

    fun execute(name : String) : ValidationResult
    {
        if (name.isBlank())
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Name Cannot be Empty"
            )
        }
        val containLetter = name.any { it.isLowerCase() } && name.any { it.isUpperCase() } && name.any { it.isDigit() }
        if (!containLetter)
        {
            return ValidationResult(
                successState = false ,
                errorMessage = "Name should be only letter not digit"
            )
        }

        return ValidationResult(
            successState = true
        )
    }

}
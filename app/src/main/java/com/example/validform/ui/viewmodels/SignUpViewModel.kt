package com.example.validform.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.validform.form_valid.FormState
import com.example.validform.form_valid.validationCheck.EmailValidationCheck
import com.example.validform.form_valid.validationCheck.NameValidationCheck
import com.example.validform.form_valid.validationCheck.PasswordValidCheck
import com.example.validform.form_valid.validationCheck.RepeatPasswordValidCheck
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SignUpViewModel constructor(
    val validName : NameValidationCheck = NameValidationCheck(),
    val validEmail : EmailValidationCheck = EmailValidationCheck(),
    val validPassword : PasswordValidCheck = PasswordValidCheck(),
    val validRepeatPassword : RepeatPasswordValidCheck = RepeatPasswordValidCheck()
): ViewModel() {

     var formState by mutableStateOf<FormState>(FormState())

    private  val _uiState = Channel<UiEvents>()
    val uiState = _uiState.receiveAsFlow()

   //for ui or state updation
    fun onEvent(event : SignUpEvents)
    {
        when(event)
        {
            is SignUpEvents.NameEnter ->{
                formState = formState.copy(name = event.name)
            }
            is SignUpEvents.EmailEnter ->{
                formState = formState.copy( email = event.email)
            }
            is SignUpEvents.PasswordEnter ->{
                formState = formState.copy( password = event.password)
            }
            is SignUpEvents.RePasswordEnter ->{
                formState = formState.copy( repeatPassword = event.rPassword)
            }
            is SignUpEvents.SubmitClicked ->{
                checkValidation()
            }
        }
    }

    private fun checkValidation() {
       val name = validName.execute(formState.name)
        val email = validEmail.execute(formState.email)
        val password = validPassword.execute(formState.password)
        val rPassword = validRepeatPassword.execute(formState.password , formState.repeatPassword)

        val isError = listOf(
            name ,email ,password , rPassword
        ).any{ !it.successState}  //any is not successfull means everthing has error

        if (isError)
        {
            formState = formState.copy(
                nameError = name.errorMessage,
                emailError = email.errorMessage,
                passwordError = password.errorMessage,
                repeatPasswordError = rPassword.errorMessage
            )
            return
        }


        //sending success
        viewModelScope.launch {
            _uiState.send(UiEvents.OnSuccess)
        }


    }


}

sealed class UiEvents{
    object OnSuccess : UiEvents()
}


sealed class SignUpEvents
{
    data class NameEnter(val name : String) : SignUpEvents()
    data class EmailEnter(val email :String) : SignUpEvents()
    data class PasswordEnter(val password : String) : SignUpEvents()
    data class RePasswordEnter(val rPassword : String) : SignUpEvents()
    object SubmitClicked : SignUpEvents()

}
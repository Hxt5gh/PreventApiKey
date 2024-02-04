package com.example.validform.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.validform.ui.components.EmailTextField
import com.example.validform.ui.components.NameTextField
import com.example.validform.ui.components.PasswordTextField
import com.example.validform.ui.components.RePasswordTextField
import com.example.validform.ui.viewmodels.SignUpEvents
import com.example.validform.ui.viewmodels.SignUpViewModel
import com.example.validform.ui.viewmodels.UiEvents


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {

    val viewModel = viewModel<SignUpViewModel>()
    val state = viewModel.formState

    val context =  LocalContext.current
    LaunchedEffect(key1 = LocalContext.current) {
        viewModel.uiState.collect { event ->
            when (event) {
                is UiEvents.OnSuccess -> {

                }
            }
        }
    }

    Surface(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize()) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {


            NameTextField(name = state.name,
                    error = state.nameError != null,
                    onValueChange = {
                        viewModel.onEvent(SignUpEvents.NameEnter(it))
                    })
            if (state.nameError != null){
                Text(text = state.nameError , color = MaterialTheme.colorScheme.error ,  modifier = Modifier.align(Alignment.End))
            }

            Spacer(modifier = Modifier.size(10.dp))

                EmailTextField(email = state.email,
                    error = state.emailError != null,
                    onValueChange = { viewModel.onEvent(SignUpEvents.EmailEnter(it)) })
            if (state.emailError != null){
                Text(text = state.emailError , color = MaterialTheme.colorScheme.error ,  modifier = Modifier.align(Alignment.End))
            }


            Spacer(modifier = Modifier.size(10.dp))
                PasswordTextField(password = state.password,
                    error = state.passwordError != null,
                    onValueChange = { viewModel.onEvent(SignUpEvents.PasswordEnter(it)) })
            if (state.passwordError != null){
                Text(text = state.passwordError , color = MaterialTheme.colorScheme.error ,  modifier = Modifier.align(Alignment.End))
            }




            Spacer(modifier = Modifier.size(10.dp))

                RePasswordTextField(rePassword = state.repeatPassword,
                    error = state.repeatPasswordError != null,
                    onValueChange = { viewModel.onEvent(SignUpEvents.RePasswordEnter(it)) })
            if (state.repeatPasswordError != null){
                Text(text = state.repeatPasswordError , color = MaterialTheme.colorScheme.error , modifier = Modifier.align(Alignment.End))
            }



            Spacer(modifier = Modifier.size(20.dp))
            Button(onClick = {
                viewModel.onEvent(SignUpEvents.SubmitClicked)
            }) {
                Text(text = "Submit")
            }

        }

    }
}
@Preview(showBackground = true)
@Composable
fun prev() {
    SignUpScreen()
}
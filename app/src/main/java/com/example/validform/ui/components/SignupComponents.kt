package com.example.validform.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameTextField(
    name: String,
    error: Boolean,
    onValueChange: (value: String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        value = name,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "Name") },
        placeholder = { Text(text = "Name") },
        textStyle = TextStyle(fontSize = 18.sp),
        isError = error,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    email: String,
    error: Boolean,
    onValueChange: (value: String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        value = email,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "Email") },
        placeholder = { Text(text = "Email") },
        textStyle = TextStyle(fontSize = 18.sp),
        isError = error,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    password: String,
    error: Boolean,
    onValueChange: (value: String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        value = password,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "Password") },
        placeholder = { Text(text = "Password") },
        textStyle = TextStyle(fontSize = 18.sp),
        isError = error,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RePasswordTextField(
    rePassword: String,
    error: Boolean,
    onValueChange: (value: String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        value = rePassword,
        onValueChange = {
            onValueChange(it)
        },
        label = { Text(text = "ReEnter Password") },
        placeholder = { Text(text = "ReEnter Password") },
        textStyle = TextStyle(fontSize = 18.sp),
        isError = error,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        )
    )
}

@Preview
@Composable
fun prev() {

      NameTextField(name = "", onValueChange = {}, error = true)
//    EmailTextField(email = "", onValueChange = {}, error = true, errorText = "notvalid")
//    PasswordTextField(password = "", onValueChange = {}, error = true, errorText = "notvalid")
//    RePasswordTextField(rePassword = "", onValueChange = {}, error = true, errorText = "notvalid")
}
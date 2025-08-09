package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForFindersScaffold
import com.kernelescape.compose.resources.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstStepFinderRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    RegistrationForFindersScaffold(
        currentStep = 1,
        totalSteps = 3,
        stepTitle = stringResource(R.string.registration_step1_title),
        primaryButtonText = stringResource(R.string.registration_button_next),
        onPrimaryButtonClick = onNextClick,
        onCloseClick = onBackClick,
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    RegistrationTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = stringResource(R.string.registration_field_name)
                    )
                }

                item {
                    RegistrationTextField(
                        value = city,
                        onValueChange = { city = it },
                        label = stringResource(R.string.registration_field_city)
                    )
                }

                item {
                    RegistrationTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = stringResource(R.string.registration_field_email)
                    )
                }


                item {
                    PasswordTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = stringResource(R.string.registration_field_password),
                        passwordVisible = passwordVisible,
                        onPasswordVisibilityChange = { passwordVisible = it }
                    )
                }

                item {
                    PasswordTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = stringResource(R.string.registration_field_confirm_password),
                        passwordVisible = confirmPasswordVisible,
                        onPasswordVisibilityChange = { confirmPasswordVisible = it }
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RegistrationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.registration_accent_teal),
            unfocusedBorderColor = colorResource(R.color.registration_accent_teal)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    passwordVisible: Boolean,
    onPasswordVisibilityChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibilityChange(!passwordVisible) }) {
                Icon(
                    painter = if (passwordVisible) painterResource(R.drawable.ic_open_eye) else painterResource(R.drawable.ic_close_eye),
                    tint = colorResource(R.color.registration_accent_orange),
                    contentDescription = "PasswordVisibility"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(R.color.registration_accent_teal),
            unfocusedBorderColor = colorResource(R.color.registration_accent_teal)
        )
    )
}
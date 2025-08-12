package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForWorker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.PasswordTextField
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForWorkersScaffold
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationTextField
import com.kernelescape.compose.resources.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstStepWorkerRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var position by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    RegistrationForWorkersScaffold(
        currentStep = 1,
        totalSteps = 2,
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
                        label = stringResource(R.string.registration_field_full_name)
                    )
                }

                item {
                    RegistrationTextField(
                        value = position,
                        onValueChange = { position = it },
                        label = stringResource(R.string.registration_field_post)
                    )
                }

                item {
                    RegistrationTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = stringResource(R.string.registration_field_phone)
                    )
                }

                item {
                    RegistrationTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = stringResource(R.string.registration_field_work_email)
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

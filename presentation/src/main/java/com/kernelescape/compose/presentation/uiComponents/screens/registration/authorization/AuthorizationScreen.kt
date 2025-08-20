package com.kernelescape.compose.presentation.uiComponents.screens.registration.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.PasswordTextField
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationTextField
import com.kernelescape.compose.resources.R

@Composable
fun AuthorizationScreen(
    onEnterClick: () -> Unit,
    onGoToRegistration: () -> Unit
) {
    val sfProTextMedium = FontFamily(Font(R.font.sf_pro_text_regular, weight = FontWeight.Medium))

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    AuthorizationScaffold(
        onBackClick = onGoToRegistration,
        onActionClick = onEnterClick,
        actionButtonText = "Войти"
    ) {
        // Main content area
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Illustration
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_success_sent_information_screen),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier =
                        Modifier
                            .fillMaxWidth(0.85f)
                            .heightIn(max = 280.dp)
                )
            }

            // Title
            Text(
                text = "Авторизация",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            RegistrationTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.registration_field_email)
            )

            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.authorization_password),
                passwordVisible = passwordVisible,
                onPasswordVisibilityChange = { passwordVisible = it },
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Забыли пароль?",
                textAlign = TextAlign.Center,
                fontSize = 13.sp,
                color = Color(0xFFDB643E),
                fontFamily = sfProTextMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    AuthorizationScreen(
        onEnterClick = {},
        onGoToRegistration = {}
    )
}
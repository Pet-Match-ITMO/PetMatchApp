package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationHub

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationScaffold
import com.kernelescape.compose.resources.R

/**
 * Экран выбора типа регистрации пользователя
 * Позволяет выбрать между поиском питомца и работой в приюте
 */
@Composable
fun RegistrationHubScreen(
    onLookingForPetClick: () -> Unit = {},
    onShelterWorkerClick: () -> Unit = { /* Navigation to FirstStepWorkerRegistration */ },
    onAlreadyHaveAccountClick: () -> Unit = {},
    onCloseClick: () -> Unit = {}
) {
    RegistrationScaffold(
        onCloseClick = onCloseClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Illustration - адаптивная иллюстрация
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_registration_hub),
                    contentDescription = stringResource(id = R.string.registration_illustration_content_description),
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth(0.85f) // 85% от ширины экрана
                        .heightIn(max = 280.dp) // Максимальная высота с возможностью уменьшения
                )
            }

            // Title
            Text(
                text = stringResource(id = R.string.registration_title),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )

            // Subtitle
            Text(
                text = stringResource(id = R.string.registration_subtitle),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            // Button Group - адаптивная группа кнопок
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                // Кнопка "Ищу питомца"
                Button(
                    onClick = onLookingForPetClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp), // Более современный радиус
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.registration_looking_for_pet),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = stringResource(id = R.string.pet_icon_content_description),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Кнопка "Работаю в приюте"
                Button(
                    onClick = { onShelterWorkerClick() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.registration_shelter_worker),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Outlined.Home,
                        contentDescription = stringResource(id = R.string.shelter_icon_content_description),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Кнопка "Уже есть аккаунт"
                TextButton(
                    onClick = onAlreadyHaveAccountClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.registration_already_have_account),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
    }
}

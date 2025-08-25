package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.common.PrimaryButton
import com.kernelescape.compose.resources.R

@Composable
fun OnboardingScaffold(
    currentStep: Int,
    buttonText: String,
    onContinueClick: () -> Unit,
    onCloseClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(all = 4.dp)
    ) {
        // Основная колонка с контентом
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Контент экрана (иллюстрация, заголовок, подзаголовок) - больше места
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .padding(top = 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                content()

                // Close button positioned in top-right corner of content area
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_circle),
                    contentDescription = "Close",
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier =
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            top = 16.dp,
                            end = 16.dp
                        ).clickable { onCloseClick() }
                )
            }

            // Индикаторы шагов - компактно
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                // Фиксированный отступ вместо веса
                contentAlignment = Alignment.Center
            ) {
                AnimatedStepIndicator(
                    currentStep = currentStep,
                    totalSteps = 4,
                    activeColor = MaterialTheme.colorScheme.secondary,
                    inactiveColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.3f)
                )
            }

            // Минимальный отступ перед кнопкой
            Spacer(modifier = Modifier.weight(2f))

            // Кнопка в нижней части
            PrimaryButton(
                text = buttonText,
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

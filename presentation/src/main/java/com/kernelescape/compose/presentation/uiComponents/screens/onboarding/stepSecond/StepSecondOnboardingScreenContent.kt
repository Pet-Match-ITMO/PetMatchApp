package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepSecond

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components.OnboardingContentBase
import com.kernelescape.compose.resources.R

/**
 * Контент второго шага онбординга
 * Отображает информацию о функции искусственного интеллекта
 */
@Composable
fun StepSecondOnboardingScreenContent(modifier: Modifier = Modifier) {
    OnboardingContentBase(
        illustrationRes = R.drawable.onboarding_second_step_illustration,
        title = stringResource(id = R.string.onboarding_step_second_title),
        subtitle = stringResource(id = R.string.onboarding_step_second_subtitle),
        modifier = modifier,
    )
}

package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepThird

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components.OnboardingContentBase
import com.kernelescape.compose.resources.R

/**
 * Контент третьего шага онбординга
 * Отображает советы по использованию приложения
 */
@Composable
fun StepThirdOnboardingScreenContent(modifier: Modifier = Modifier) {
    OnboardingContentBase(
        illustrationRes = R.drawable.onboarding_third_step_illustration,
        title = stringResource(id = R.string.onboarding_step_third_title),
        subtitle = stringResource(id = R.string.onboarding_step_third_subtitle),
        modifier = modifier
    )
}

package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepFourth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components.OnboardingContentBase
import com.kernelescape.compose.resources.R

/**
 * Контент четвертого шага онбординга
 * Отображает информацию о благотворительности
 */
@Composable
fun StepFourthOnboardingScreenContent(modifier: Modifier = Modifier) {
    OnboardingContentBase(
        illustrationRes = R.drawable.onboarding_fourth_step_illustration,
        title = stringResource(id = R.string.onboarding_step_fourth_title),
        subtitle = stringResource(id = R.string.onboarding_step_fourth_subtitle),
        modifier = modifier
    )
}

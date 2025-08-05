package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepFirst

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components.OnboardingContentBase
import com.kernelescape.compose.resources.R

/**
 * Контент первого шага онбординга
 * Отображает иллюстрацию, заголовок и описание приветственного экрана
 */
@Composable
fun StepFirstOnboardingScreenContent(modifier: Modifier = Modifier) {
    OnboardingContentBase(
        illustrationRes = R.drawable.onboarding_first_step_illustration,
        title = stringResource(id = R.string.onboarding_step_first_title),
        subtitle = stringResource(id = R.string.onboarding_step_first_subtitle),
        modifier = modifier
    )
}

package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepFirst.StepFirstOnboardingScreenContent
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepFourth.StepFourthOnboardingScreenContent
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepSecond.StepSecondOnboardingScreenContent
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.stepThird.StepThirdOnboardingScreenContent
import kotlinx.coroutines.launch

/**
 * Улучшенный экран с пагинацией для онбординга пользователя.
 * Обеспечивает плавные свайпы между экранами с общими UI элементами:
 * - Единая кнопка "Далее/Завершить" для всех экранов
 * - Общие индикаторы (пузырики) с анимацией
 * - Единая кнопка закрытия (ic_close_circle)
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingPagerScreen(
    onFinishOnboarding: () -> Unit,
    onCloseClick: () -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { 4 })
    val coroutineScope = rememberCoroutineScope()

    // Определяем текст кнопки в зависимости от текущей страницы
    val buttonText =
        when (pagerState.currentPage) {
            3 -> "Завершить"
            else -> "Далее"
        }

    // Определяем действие кнопки в зависимости от текущей страницы
    val onContinueClick: () -> Unit = {
        when (pagerState.currentPage) {
            0, 1, 2 -> {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(
                        page = pagerState.currentPage + 1,
                        animationSpec =
                        androidx.compose.animation.core.tween(
                            durationMillis = 500,
                            easing = androidx.compose.animation.core.FastOutSlowInEasing
                        )
                    )
                }
            }
            3 -> onFinishOnboarding()
            else -> Unit
        }
    }

    OnboardingScaffold(
        currentStep = pagerState.currentPage + 1,
        buttonText = buttonText,
        onContinueClick = onContinueClick,
        onCloseClick = onCloseClick
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize(),
            userScrollEnabled = true
        ) { page ->
            when (page) {
                0 ->
                    StepFirstOnboardingScreenContent(
                        modifier = Modifier.fillMaxSize()
                    )
                1 ->
                    StepSecondOnboardingScreenContent(
                        modifier = Modifier.fillMaxSize()
                    )
                2 ->
                    StepThirdOnboardingScreenContent(
                        modifier = Modifier.fillMaxSize()
                    )
                3 ->
                    StepFourthOnboardingScreenContent(
                        modifier = Modifier.fillMaxSize()
                    )
            }
        }
    }
}

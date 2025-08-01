package com.kernelescape.compose.presentation.navigation

import androidx.compose.runtime.Composable
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components.OnboardingPagerScreen

/**
 * Упрощенный NavHost для раздела онбординга пользователя.
 * Теперь использует единый OnboardingPagerScreen с HorizontalPager для свайпов
 * и общими UI элементами (кнопка, индикаторы, кнопка закрытия) для всех экранов.
 *
 * Преимущества новой архитектуры:
 * - Единая кнопка "Далее/Завершить" для всех экранов
 * - Общие анимированные индикаторы (пузырики)
 * - Единая кнопка закрытия (ic_close_circle)
 * - Плавные свайпы между экранами с HorizontalPager
 * - Устранение дублирования UI элементов
 */
@Composable
fun OnboardingNavHost(
    onFinishOnboarding: () -> Unit,
    onSkipOnboarding: () -> Unit,
) {
    OnboardingPagerScreen(
        onFinishOnboarding = onFinishOnboarding,
        onCloseClick = onSkipOnboarding,
    )
}

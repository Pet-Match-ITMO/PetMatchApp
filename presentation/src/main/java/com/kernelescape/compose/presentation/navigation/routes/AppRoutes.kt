package com.kernelescape.compose.presentation.navigation.routes

/**
 * Определяет основные маршруты навигации для главного NavHost приложения.
 * Содержит только онбординг раздел.
 */
sealed class AppRoutes(
    val route: String
) {
    /** Раздел онбординга - первое знакомство пользователя с приложением */
    object Onboarding : AppRoutes("onboarding_section")
}

package com.kernelescape.compose.presentation.navigation.routes

/**
 * Определяет маршруты навигации для раздела регистрации.
 * Содержит экран выбора типа регистрации (хаб).
 */
sealed class RegistrationRoutes(
    val route: String
) {
    /** Экран выбора типа регистрации - хаб регистрации */
    object RegistrationHub : RegistrationRoutes("registration_hub")
    
    /** Первый шаг регистрации для поиска питомца */
    object FirstStepFinderRegistration : RegistrationRoutes("first_step_finder_registration")
    
    /** Второй шаг регистрации для поиска питомца */
    object SecondStepFinderRegistration : RegistrationRoutes("second_step_finder_registration")
    
    /** Третий шаг регистрации для поиска питомца */
    object ThirdStepFinderRegistration : RegistrationRoutes("third_step_finder_registration")
}
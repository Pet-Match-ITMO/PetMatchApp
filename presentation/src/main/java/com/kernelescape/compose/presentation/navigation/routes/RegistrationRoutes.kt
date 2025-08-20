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

    /** Успех регистрации для поиска питомца */
    object SuccessRegistrationScreenForFinders : RegistrationRoutes("success_registration_screen_for_finder")

    /** Первый шаг регистрации для работника приюта */
    object FirstStepWorkerRegistration : RegistrationRoutes("first_step_worker_registration")

    /** Второй шаг регистрации для работника приюта */
    object SecondStepWorkerRegistration : RegistrationRoutes("second_step_worker_registration")

    /** Успех регистрации для работника приюта */
    object SuccessRegistrationScreenForWorkers : RegistrationRoutes("success_registration_screen_for_worker")

    /** Экран авторизации */
    object Authorization : RegistrationRoutes("authorization")
}

package com.kernelescape.compose.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kernelescape.compose.presentation.navigation.routes.AppRoutes

/**
 * Главный NavHost приложения, который управляет навигацией между основными разделами.
 * Содержит онбординг и регистрацию NavHost.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.Onboarding.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        modifier = modifier
    ) {
        // Дочерний NavHost для онбординга с собственным Scaffold
        composable(AppRoutes.Onboarding.route) {
            OnboardingNavHost(
                onFinishOnboarding = {
                    navController.navigate(AppRoutes.Registration.route) {
                        popUpTo(AppRoutes.Onboarding.route) { inclusive = true }
                    }
                },
                onSkipOnboarding = {
                    navController.navigate(AppRoutes.Registration.route) {
                        popUpTo(AppRoutes.Onboarding.route) { inclusive = true }
                    }
                }
            )
        }

        // Дочерний NavHost для регистрации
        composable(AppRoutes.Registration.route) {
            RegistrationNavHost(
                navController = rememberNavController()
            )
        }
    }
}

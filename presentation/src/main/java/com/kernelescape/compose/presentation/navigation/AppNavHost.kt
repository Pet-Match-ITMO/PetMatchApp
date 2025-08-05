package com.kernelescape.compose.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kernelescape.compose.presentation.navigation.routes.AppRoutes

/**
 * Главный NavHost приложения, который управляет навигацией между основными разделами.
 * Содержит только онбординг NavHost.
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
                    // TODO: Navigate to main app after onboarding
                },
                onSkipOnboarding = {
                    // TODO: Navigate to main app after onboarding
                }
            )
        }
    }
}

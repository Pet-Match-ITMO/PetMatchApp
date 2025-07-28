package com.kernelescape.compose.presentation.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.kernelescape.compose.presentation.uiComponents.screens.onboarding.OnboardingPagerScreen

/**
 * Маршруты навигации
 */
sealed class Screen(val route: String) {
    // Маршруты для онбординга
    object Onboarding {
        const val GRAPH = "onboarding"
        object Pager : Screen("onboarding_pager")
    }
    
    // Другие маршруты приложения могут быть добавлены позже
    object Main : Screen("main")
}

/**
 * Модуль навигации приложения
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.GRAPH,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        modifier = modifier
    ) {
        // Подграф для онбординга
        onboardingGraph(navController)
        
        // Здесь можно добавить другие подграфы для других частей приложения
        // Например, основной граф приложения
        composable(Screen.Main.route) {
            // Здесь будет основной экран приложения
        }
    }
}

/**
 * Подграф навигации для экранов онбординга
 */
private fun NavGraphBuilder.onboardingGraph(navController: NavHostController) {
    navigation(
        startDestination = Screen.Onboarding.Pager.route,
        route = Screen.Onboarding.GRAPH
    ) {
        composable(Screen.Onboarding.Pager.route) {
            OnboardingPagerScreen(
                onFinishOnboarding = {
                    // Завершаем онбординг и переходим к основному экрану
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Onboarding.GRAPH) { inclusive = true }
                    }
                },
                onCloseClick = {
                    // Сразу переходим на основной экран, пропуская онбординг
                    navController.navigate(Screen.Main.route) {
                        popUpTo(Screen.Onboarding.GRAPH) { inclusive = true }
                    }
                }
            )
        }
    }
}
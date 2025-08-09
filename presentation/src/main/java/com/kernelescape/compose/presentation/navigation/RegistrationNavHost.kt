package com.kernelescape.compose.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kernelescape.compose.presentation.navigation.routes.RegistrationRoutes
import com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationHub.RegistrationHubScreen
import com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder.FirstStepFinderRegistration
import com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder.SecondStepFinderRegistration
import com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder.ThirdStepFinderRegistration

/**
 * NavHost для управления навигацией в разделе регистрации.
 * Содержит экран выбора типа регистрации (хаб) и экраны регистрации для поиска питомца.
 *
 * @param navController Контроллер навигации для управления переходами
 */
@Composable
fun RegistrationNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RegistrationRoutes.RegistrationHub.route
    ) {
        composable(route = RegistrationRoutes.RegistrationHub.route) {
            RegistrationHubScreen(
                onLookingForPetClick = {
                    navController.navigate(RegistrationRoutes.FirstStepFinderRegistration.route)
                },
                onShelterWorkerClick = {
                    // TODO: Implement shelter worker registration navigation
                },
                onAlreadyHaveAccountClick = {
                    // TODO: Implement login navigation
                },
                onCloseClick = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(route = RegistrationRoutes.FirstStepFinderRegistration.route) {
            FirstStepFinderRegistration(
                onBackClick = {
                    navController.popBackStack()
                },
                onNextClick = {
                    navController.navigate(RegistrationRoutes.SecondStepFinderRegistration.route)
                }
            )
        }
        
        composable(route = RegistrationRoutes.SecondStepFinderRegistration.route) {
            SecondStepFinderRegistration(
                onBackClick = {
                    navController.popBackStack()
                },
                onNextClick = {
                    navController.navigate(RegistrationRoutes.ThirdStepFinderRegistration.route)
                }
            )
        }
        
        composable(route = RegistrationRoutes.ThirdStepFinderRegistration.route) {
            ThirdStepFinderRegistration(
                onBackClick = {
                    navController.popBackStack()
                },
                onConfirmClick = {
                    // TODO: Implement registration completion logic
                    navController.popBackStack(RegistrationRoutes.RegistrationHub.route, inclusive = true)
                }
            )
        }
    }
}
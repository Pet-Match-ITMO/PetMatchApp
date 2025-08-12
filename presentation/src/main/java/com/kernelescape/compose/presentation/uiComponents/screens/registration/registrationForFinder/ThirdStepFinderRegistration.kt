package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForFindersScaffold
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.TagSection
import com.kernelescape.compose.resources.R
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentOrange
import com.kernelescape.compose.resources.ui.theme.RegistrationPrimaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationSecondaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationWhite

@Composable
fun ThirdStepFinderRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onConfirmClick: () -> Unit = {}
) {
    val textPrimaryColor = RegistrationPrimaryText
    val textSecondaryColor = RegistrationSecondaryText

    // Default values for state
    val defaultActivity = stringResource(R.string.registration_option_any_feminine)
    val defaultCharacter = stringResource(R.string.registration_option_any_masculine)
    val defaultHealth = stringResource(R.string.registration_option_any_neuter)
    val defaultPetCompatibility = stringResource(R.string.registration_pet_compatibility_not_required)
    val defaultHumanCompatibility = stringResource(R.string.registration_human_compatibility_all)

    // State for all tag groups
    var selectedActivity by remember { mutableStateOf(defaultActivity) }
    var selectedCharacter by remember { mutableStateOf(defaultCharacter) }
    var selectedHealth by remember { mutableStateOf(defaultHealth) }
    var selectedPetCompatibility by remember { mutableStateOf(defaultPetCompatibility) }
    var selectedHumanCompatibility by remember { mutableStateOf(defaultHumanCompatibility) }

    val accentColor = RegistrationAccentOrange
    val primaryTextColor = RegistrationPrimaryText
    val whiteColor = RegistrationWhite

    RegistrationForFindersScaffold(
        currentStep = 3,
        totalSteps = 3,
        stepTitle = stringResource(R.string.registration_step3_title),
        primaryButtonText = stringResource(R.string.registration_button_confirm),
        secondaryButtonText = stringResource(R.string.registration_button_reset_params),
        onPrimaryButtonClick = onConfirmClick,
        onSecondaryButtonClick = {
            selectedActivity = defaultActivity
            selectedCharacter = defaultCharacter
            selectedHealth = defaultHealth
            selectedPetCompatibility = defaultPetCompatibility
            selectedHumanCompatibility = defaultHumanCompatibility
        },
        onCloseClick = onBackClick,
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 0.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Activity tag group
                item {
                    TagSection(
                        title = stringResource(R.string.registration_activity_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_feminine),
                            stringResource(R.string.registration_activity_passive),
                            stringResource(R.string.registration_activity_moderate),
                            stringResource(R.string.registration_activity_active),
                            stringResource(R.string.registration_activity_hyperactive)
                        ),
                        selectedTag = selectedActivity,
                        onTagSelected = { selectedActivity = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor,
                        chipShape = CircleShape
                    )
                }

                // Character tag group
                item {
                    TagSection(
                        title = stringResource(R.string.registration_character_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_masculine),
                            stringResource(R.string.registration_character_calm),
                            stringResource(R.string.registration_character_shy),
                            stringResource(R.string.registration_character_gentle),
                            stringResource(R.string.registration_character_affectionate),
                            stringResource(R.string.registration_character_friendly),
                            stringResource(R.string.registration_character_playful),
                            stringResource(R.string.registration_character_restless)
                        ),
                        selectedTag = selectedCharacter,
                        onTagSelected = { selectedCharacter = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor,
                        chipShape = CircleShape
                    )
                }

                // Health tag group
                item {
                    TagSection(
                        title = stringResource(R.string.registration_health_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_neuter),
                            stringResource(R.string.registration_health_fully_healthy),
                            stringResource(R.string.registration_health_sterilized),
                            stringResource(R.string.registration_health_vaccinated),
                            stringResource(R.string.registration_health_allergies),
                            stringResource(R.string.registration_health_minor_conditions),
                            stringResource(R.string.registration_health_recovering),
                            stringResource(R.string.registration_health_recurring_conditions),
                            stringResource(R.string.registration_health_chronic_conditions),
                            stringResource(R.string.registration_health_physical_injuries),
                            stringResource(R.string.registration_health_disability)
                        ),
                        selectedTag = selectedHealth,
                        onTagSelected = { selectedHealth = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor,
                        chipShape = CircleShape
                    )
                }

                // Pet compatibility tag group
                item {
                    TagSection(
                        title = stringResource(R.string.registration_pet_compatibility_title),
                        tags = listOf(
                            stringResource(R.string.registration_pet_compatibility_not_required),
                            stringResource(R.string.registration_pet_compatibility_cats),
                            stringResource(R.string.registration_pet_compatibility_dogs),
                            stringResource(R.string.registration_pet_compatibility_other),
                            stringResource(R.string.registration_pet_compatibility_all)
                        ),
                        selectedTag = selectedPetCompatibility,
                        onTagSelected = { selectedPetCompatibility = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor,
                        chipShape = CircleShape
                    )
                }

                // Human compatibility tag group
                item {
                    com.kernelescape.compose.presentation.uiComponents.screens.registration.components.TagSection(
                        title = stringResource(R.string.registration_human_compatibility_title),
                        tags = listOf(
                            stringResource(R.string.registration_human_compatibility_all),
                            stringResource(R.string.registration_human_compatibility_children),
                            stringResource(R.string.registration_human_compatibility_noisy),
                            stringResource(R.string.registration_human_compatibility_men)
                        ),
                        selectedTag = selectedHumanCompatibility,
                        onTagSelected = { selectedHumanCompatibility = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor,
                        chipShape = CircleShape
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ThirdStepFinderRegistrationPreview() {
    ThirdStepFinderRegistration()
}

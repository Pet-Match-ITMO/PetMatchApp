package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForFindersScaffold
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.TagSection
import com.kernelescape.compose.resources.R
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentOrange
import com.kernelescape.compose.resources.ui.theme.RegistrationPrimaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationWhite

@Composable
fun SecondStepFinderRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val primaryTextColor = RegistrationPrimaryText
    val accentColor = RegistrationAccentOrange
    val whiteColor = RegistrationWhite

    // State for selected options
    val anyMasculine = stringResource(R.string.registration_option_any_masculine)
    val anyFeminine = stringResource(R.string.registration_option_any_feminine)

    var selectedPetType by remember { mutableStateOf(anyMasculine) }
    var selectedAge by remember { mutableStateOf(anyMasculine) }
    var selectedGender by remember { mutableStateOf(anyMasculine) }
    var selectedBreed by remember { mutableStateOf(anyFeminine) }
    var selectedFur by remember { mutableStateOf(anyFeminine) }
    var selectedSize by remember { mutableStateOf(anyMasculine) }

    RegistrationForFindersScaffold(
        currentStep = 2,
        totalSteps = 3,
        stepTitle = stringResource(R.string.registration_step2_title),
        primaryButtonText = stringResource(R.string.registration_button_next),
        secondaryButtonText = stringResource(R.string.registration_button_reset_params),
        onPrimaryButtonClick = onNextClick,
        onSecondaryButtonClick = {
            selectedPetType = anyMasculine
            selectedAge = anyMasculine
            selectedGender = anyMasculine
            selectedBreed = anyFeminine
            selectedFur = anyFeminine
            selectedSize = anyMasculine
        },
        onCloseClick = onBackClick,
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 0.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    TagSection(
                        title = stringResource(R.string.registration_pet_type_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_masculine),
                            stringResource(R.string.registration_pet_type_cat),
                            stringResource(R.string.registration_pet_type_dog),
                            stringResource(R.string.registration_pet_type_other)
                        ),
                        selectedTag = selectedPetType,
                        onTagSelected = { selectedPetType = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }

                item {
                    TagSection(
                        title = stringResource(R.string.registration_age_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_masculine),
                            stringResource(R.string.registration_age_up_to_6_months),
                            stringResource(R.string.registration_age_up_to_1_year),
                            stringResource(R.string.registration_age_1_to_3_years),
                            stringResource(R.string.registration_age_3_to_5_years),
                            stringResource(R.string.registration_age_5_to_7_years),
                            stringResource(R.string.registration_age_7_to_10_years),
                            stringResource(R.string.registration_age_over_10_years)
                        ),
                        selectedTag = selectedAge,
                        onTagSelected = { selectedAge = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }

                item {
                    TagSection(
                        title = stringResource(R.string.registration_gender_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_masculine),
                            stringResource(R.string.registration_gender_male),
                            stringResource(R.string.registration_gender_female)
                        ),
                        selectedTag = selectedGender,
                        onTagSelected = { selectedGender = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }

                item {
                    TagSection(
                        title = stringResource(R.string.registration_finder_breed_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_feminine),
                            stringResource(R.string.registration_finder_breed_mixed),
                            stringResource(R.string.registration_finder_breed_crossbreed),
                            stringResource(R.string.registration_finder_breed_purebred)
                        ),
                        selectedTag = selectedBreed,
                        onTagSelected = { selectedBreed = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }

                item {
                    TagSection(
                        title = stringResource(R.string.registration_finder_fur_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_feminine),
                            stringResource(R.string.registration_finder_fur_hairless),
                            stringResource(R.string.registration_finder_fur_short),
                            stringResource(R.string.registration_finder_fur_long)
                        ),
                        selectedTag = selectedFur,
                        onTagSelected = { selectedFur = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }

                item {
                    TagSection(
                        title = stringResource(R.string.registration_finder_size_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_masculine),
                            stringResource(R.string.registration_finder_size_small),
                            stringResource(R.string.registration_finder_size_medium),
                            stringResource(R.string.registration_finder_size_large)
                        ),
                        selectedTag = selectedSize,
                        onTagSelected = { selectedSize = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }
            }
        }
    )
}

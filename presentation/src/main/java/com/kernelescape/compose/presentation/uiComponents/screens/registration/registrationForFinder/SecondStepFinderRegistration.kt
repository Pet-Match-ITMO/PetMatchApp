package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForFindersScaffold
import com.kernelescape.compose.resources.R

@Composable
fun SecondStepFinderRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val primaryTextColor = colorResource(R.color.registration_primary_text)
    val accentColor = colorResource(R.color.registration_accent_orange)
    val whiteColor = colorResource(R.color.registration_white)

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

@Composable
fun TagSection(
    title: String,
    tags: List<String>,
    selectedTag: String,
    onTagSelected: (String) -> Unit,
    accentColor: Color,
    primaryTextColor: Color,
    whiteColor: Color
) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                color = colorResource(R.color.registration_secondary_text)
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tags.forEach { tag ->
                TagChip(
                    text = tag,
                    isSelected = tag == selectedTag,
                    onClick = { onTagSelected(tag) },
                    accentColor = accentColor,
                    primaryTextColor = primaryTextColor,
                    whiteColor = whiteColor
                )
            }
        }
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val rows = mutableListOf<List<androidx.compose.ui.layout.Placeable>>()
        val rowConstraints = constraints.copy(minWidth = 0)

        var currentRow = mutableListOf<androidx.compose.ui.layout.Placeable>()
        var currentRowWidth = 0
        var currentRowItemCount = 0

        measurables.forEach { measurable ->
            val placeable = measurable.measure(rowConstraints)

            if (currentRowWidth + placeable.width > constraints.maxWidth || currentRowItemCount >= maxItemsInEachRow) {
                rows.add(currentRow)
                currentRow = mutableListOf()
                currentRowWidth = 0
                currentRowItemCount = 0
            }

            currentRow.add(placeable)
            currentRowWidth += placeable.width
            if (currentRow.size > 1) {
                currentRowWidth += horizontalArrangement.spacing.roundToPx()
            }
            currentRowItemCount++
        }

        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
        }

        val height = rows.sumOf { row -> row.maxOfOrNull { it.height } ?: 0 } +
                if (rows.size > 1) (rows.size - 1) * verticalArrangement.spacing.roundToPx() else 0

        layout(constraints.maxWidth, height) {
            var y = 0

            rows.forEach { row ->
                val rowHeight = row.maxOfOrNull { it.height } ?: 0
                var x = 0

                row.forEach { placeable ->
                    placeable.place(x, y)
                    x += placeable.width + horizontalArrangement.spacing.roundToPx()
                }

                y += rowHeight + verticalArrangement.spacing.roundToPx()
            }
        }
    }
}

@Composable
fun TagChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    accentColor: Color,
    primaryTextColor: Color,
    whiteColor: Color
) {
    val backgroundColor = if (isSelected) accentColor else whiteColor
    val textColor = if (isSelected) whiteColor else primaryTextColor

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                color = textColor
            )
        )
    }
}

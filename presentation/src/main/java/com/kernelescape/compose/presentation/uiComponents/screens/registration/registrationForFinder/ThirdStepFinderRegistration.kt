package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForFinder

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForFindersScaffold
import com.kernelescape.compose.resources.R

@Composable
fun ThirdStepFinderRegistration(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onConfirmClick: () -> Unit = {}
) {
    val textPrimaryColor = colorResource(R.color.registration_primary_text)
    val textSecondaryColor = colorResource(R.color.registration_secondary_text)

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
                    TagGroup(
                        title = stringResource(R.string.registration_activity_title),
                        tags = listOf(
                            stringResource(R.string.registration_option_any_feminine),
                            stringResource(R.string.registration_activity_passive),
                            stringResource(R.string.registration_activity_moderate),
                            stringResource(R.string.registration_activity_active),
                            stringResource(R.string.registration_activity_hyperactive)
                        ),
                        selectedTag = selectedActivity,
                        onTagSelected = { selectedActivity = it }
                    )
                }

                // Character tag group
                item {
                    TagGroup(
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
                        onTagSelected = { selectedCharacter = it }
                    )
                }

                // Health tag group
                item {
                    TagGroup(
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
                        onTagSelected = { selectedHealth = it }
                    )
                }

                // Pet compatibility tag group
                item {
                    TagGroup(
                        title = stringResource(R.string.registration_pet_compatibility_title),
                        tags = listOf(
                            stringResource(R.string.registration_pet_compatibility_not_required),
                            stringResource(R.string.registration_pet_compatibility_cats),
                            stringResource(R.string.registration_pet_compatibility_dogs),
                            stringResource(R.string.registration_pet_compatibility_other),
                            stringResource(R.string.registration_pet_compatibility_all)
                        ),
                        selectedTag = selectedPetCompatibility,
                        onTagSelected = { selectedPetCompatibility = it }
                    )
                }

                // Human compatibility tag group
                item {
                    TagGroup(
                        title = stringResource(R.string.registration_human_compatibility_title),
                        tags = listOf(
                            stringResource(R.string.registration_human_compatibility_all),
                            stringResource(R.string.registration_human_compatibility_children),
                            stringResource(R.string.registration_human_compatibility_noisy),
                            stringResource(R.string.registration_human_compatibility_men)
                        ),
                        selectedTag = selectedHumanCompatibility,
                        onTagSelected = { selectedHumanCompatibility = it }
                    )
                }
            }
        }
    )
}

@Composable
fun TagGroup(
    title: String,
    tags: List<String>,
    selectedTag: String,
    onTagSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = title,
            fontSize = 15.sp,
            color = colorResource(R.color.registration_secondary_text),
            modifier = Modifier.fillMaxWidth()
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tags.forEach { tag ->
                TagChip(
                    text = tag,
                    isSelected = tag == selectedTag,
                    onClick = { onTagSelected(tag) }
                )
            }
        }
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val horizontalGapPx = 8.dp.roundToPx()
        val verticalGapPx = 8.dp.roundToPx()

        // Сначала измеряем все элементы один раз
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints.copy(minWidth = 0))
        }

        val rows = mutableListOf<MutableList<androidx.compose.ui.layout.Placeable>>()
        var currentRow = mutableListOf<androidx.compose.ui.layout.Placeable>()
        var currentRowWidth = 0

        placeables.forEach { placeable ->
            if (currentRowWidth + placeable.width > constraints.maxWidth && currentRow.isNotEmpty()) {
                rows.add(currentRow)
                currentRow = mutableListOf()
                currentRowWidth = 0
            }

            currentRow.add(placeable)
            currentRowWidth += placeable.width + if (currentRow.size > 1) horizontalGapPx else 0
        }

        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
        }

        val totalHeight = rows.sumOf { row -> row.maxOfOrNull { it.height } ?: 0 } +
                if (rows.size > 1) (rows.size - 1) * verticalGapPx else 0

        layout(constraints.maxWidth, totalHeight) {
            var yPos = 0

            rows.forEach { row ->
                var xPos = 0
                val rowHeight = row.maxOfOrNull { it.height } ?: 0

                row.forEach { placeable ->
                    placeable.place(xPos, yPos + (rowHeight - placeable.height) / 2)
                    xPos += placeable.width + horizontalGapPx
                }

                yPos += rowHeight + verticalGapPx
            }
        }
    }
}

@Composable
fun TagChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        colorResource(R.color.registration_accent_orange)
    } else {
        colorResource(R.color.registration_white)
    }

    val textColor = if (isSelected) {
        colorResource(R.color.registration_white)
    } else {
        colorResource(R.color.registration_primary_text)
    }

    Surface(
        modifier = Modifier
            .clickable { onClick() },
        shape = CircleShape,
        color = backgroundColor
    ) {
        Text(
            text = text,
            fontSize = 15.sp,
            color = textColor,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThirdStepFinderRegistrationPreview() {
    ThirdStepFinderRegistration()
}

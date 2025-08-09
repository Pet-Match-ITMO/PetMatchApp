package com.kernelescape.compose.presentation.uiComponents.screens.registration.registrationForWorker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.CustomSwitch
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationForWorkersScaffold
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.RegistrationTextField
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.TagSection
import com.kernelescape.compose.presentation.uiComponents.screens.registration.components.UploadFileCard
import com.kernelescape.compose.resources.R
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentOrange
import com.kernelescape.compose.resources.ui.theme.RegistrationPrimaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationTextPrimary
import com.kernelescape.compose.resources.ui.theme.RegistrationWhite

@Composable
fun SecondStepWorkerRegistration(onBack: () -> Unit, onComplete: () -> Unit) {
    val accentColor = RegistrationAccentOrange
    val whiteColor = RegistrationWhite
    val primaryTextColor = RegistrationPrimaryText

    var selectedSize by remember { mutableStateOf("Все") }
    var shelterName by remember { mutableStateOf("") }
    var shelterAddress by remember { mutableStateOf("") }
    var isShelterAddressVisible by remember { mutableStateOf(false) }
    var officialsSite by remember { mutableStateOf("") }

    RegistrationForWorkersScaffold(
        currentStep = 2,
        totalSteps = 2,
        stepTitle = stringResource(R.string.registration_worker_step_data_title),
        primaryButtonText = stringResource(R.string.registration_worker_step_data_confirm_button),
        onPrimaryButtonClick = onComplete,
        onCloseClick = onBack,
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    RegistrationTextField(
                        value = shelterName,
                        onValueChange = { shelterName = it },
                        label = stringResource(R.string.registration_field_shelter_name)
                    )
                }
                item {
                    RegistrationTextField(
                        value = shelterName,
                        onValueChange = { shelterName = it },
                        label = stringResource(R.string.registration_field_amount_of_animals_in_shelter)
                    )
                }
                item {
                    TagSection(
                        title = stringResource(R.string.registration_worker_pet_type_title),
                        tags = listOf(
                            stringResource(R.string.registration_worker_pet_type_all),
                            stringResource(R.string.registration_worker_pet_type_cats),
                            stringResource(R.string.registration_worker_pet_type_dogs),
                            stringResource(R.string.registration_worker_pet_type_other)
                        ),
                        selectedTag = selectedSize,
                        onTagSelected = { selectedSize = it },
                        accentColor = accentColor,
                        primaryTextColor = primaryTextColor,
                        whiteColor = whiteColor
                    )
                }
                item {
                    RegistrationTextField(
                        value = shelterAddress,
                        onValueChange = { shelterAddress = it },
                        label = stringResource(R.string.registration_field_shelter_address)
                    )
                }
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        CustomSwitch(
                            checked = isShelterAddressVisible,
                            onCheckedChange = { isShelterAddressVisible = it },
                            modifier = Modifier.padding(end = 15.dp)
                        )
                        Text(
                            text = stringResource(R.string.registration_worker_hide_shelter_address),
                            color = RegistrationTextPrimary,
                            fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 24.sp
                        )
                    }
                }
                item {
                    RegistrationTextField(
                        value = officialsSite,
                        onValueChange = { officialsSite = it },
                        label = stringResource(R.string.registration_official_site)
                    )
                }
                item {
                    RegistrationTextField(
                        value = officialsSite,
                        onValueChange = { officialsSite = it },
                        label = stringResource(R.string.registration_bills_for_charity)
                    )
                }
                item {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                        ) {
                            Icon(
                                imageVector = Icons.Filled.AddCircle,
                                contentDescription = stringResource(R.string.registration_worker_add_button),
                                tint = accentColor
                            )
                        }
                        Text(
                            text = stringResource(R.string.registration_worker_add_bill),
                            color = accentColor
                        )
                    }
                }
                item {
                    UploadFileCard(onClick = {}, hint = stringResource(R.string.registration_worker_upload_id_hint))
                }
                item {
                    UploadFileCard(onClick = {}, hint = stringResource(R.string.registration_worker_upload_contract_hint))
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SecondStepWorkerRegistrationPreview() {
    SecondStepWorkerRegistration(onBack = {}, onComplete = {})
}

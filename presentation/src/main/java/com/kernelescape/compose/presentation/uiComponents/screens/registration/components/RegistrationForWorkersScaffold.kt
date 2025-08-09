package com.kernelescape.compose.presentation.uiComponents.screens.registration.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentLightTeal
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentTeal
import com.kernelescape.compose.resources.ui.theme.RegistrationBackgroundLight
import com.kernelescape.compose.resources.ui.theme.RegistrationPrimaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationSecondaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationWhite

@Composable
fun RegistrationForWorkersScaffold(
    currentStep: Int,
    totalSteps: Int = 2,
    stepTitle: String,
    primaryButtonText: String,
    secondaryButtonText: String? = null,
    onPrimaryButtonClick: () -> Unit,
    onSecondaryButtonClick: (() -> Unit)? = null,
    onCloseClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val sfProTextMedium = FontFamily(Font(R.font.sf_pro_text_regular, weight = FontWeight.Medium))
    val backgroundColor = RegistrationBackgroundLight
    val primaryTextColor = RegistrationPrimaryText
    val secondaryTextColor = RegistrationSecondaryText
    val primaryButtonColor = RegistrationAccentTeal
    val secondaryButtonColor = RegistrationAccentLightTeal

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
            .statusBarsPadding()
            .navigationBarsPadding()
            .windowInsetsPadding(WindowInsets.ime)
    ) {
        // Основная колонка с контентом
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Верхняя часть с заголовками
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                // Заголовок с кнопкой назад и основным названием
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    // Кнопка назад слева
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(0.dp)
                            .wrapContentSize(Alignment.CenterStart),
                        onClick = onCloseClick
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_left),
                            contentDescription = "backButton",
                            modifier = Modifier
                                .align(Alignment.CenterStart)
                        )
                    }
                    // Основной заголовок
                    val previousTitle = when (currentStep) {
                        1 -> stringResource(R.string.registration)
                        2 -> stringResource(R.string.registration_step1_title)
                        else -> ""
                    }
                    if (previousTitle.isNotEmpty()) {
                        Text(
                            text = previousTitle,
                            fontSize = 17.sp,
                            fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                            fontWeight = FontWeight.Normal,
                            color = primaryTextColor,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Номер шага
                Text(
                    text = stringResource(
                        R.string.registration_step_counter,
                        currentStep,
                        totalSteps
                    ),
                    fontSize = 12.sp,
                    color = secondaryTextColor,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                // Текущий заголовок
                Text(
                    text = stepTitle,
                    fontSize = 27.sp,
                    fontFamily = FontFamily(Font(R.font.playfair_display_black)),
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Start
                )
            }

            // Контент экрана - основная часть с весом
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                content()
            }

            // Кнопки в нижней части
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Основная кнопка (Далее)
                Button(
                    onClick = onPrimaryButtonClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryButtonColor)
                ) {
                    Text(
                        text = primaryButtonText,
                        fontSize = 17.sp,
                        fontFamily = sfProTextMedium,
                        color = RegistrationWhite
                    )
                }

                // Вторичная кнопка (если есть)
                secondaryButtonText?.let { buttonText ->
                    onSecondaryButtonClick?.let { onClick ->
                        Button(
                            onClick = onClick,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            shape = RoundedCornerShape(80.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = secondaryButtonColor)
                        ) {
                            Text(
                                text = buttonText,
                                fontSize = 17.sp,
                                fontFamily = sfProTextMedium,
                                color = primaryTextColor
                            )
                        }
                    }
                }
            }
        }
    }
}

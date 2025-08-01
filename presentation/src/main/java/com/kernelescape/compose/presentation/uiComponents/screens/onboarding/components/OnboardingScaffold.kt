package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R

@Composable
fun OnboardingScaffold(
    currentStep: Int,
    buttonText: String,
    onContinueClick: () -> Unit,
    onCloseClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val sfProTextMedium = FontFamily(Font(R.font.sf_pro_text_regular, weight = FontWeight.Medium))

    val backgroundColor = Color(0xFFF4F4F4)
    val primaryColor = Color(0xFF35A2AB)
    val accentColor = Color(0xFFDB644E)

    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .statusBarsPadding()
                .navigationBarsPadding()
                .padding(all = 4.dp),
    ) {
        // Основная колонка с контентом
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 20.dp,
                    ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Контент экрана (иллюстрация, заголовок, подзаголовок) - больше места
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(top = 24.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                content()

                // Close button positioned in top-right corner of content area
                Icon(
                    painter = painterResource(id = R.drawable.ic_close_circle),
                    contentDescription = "Close",
                    tint = accentColor,
                    modifier =
                        Modifier
                            .align(Alignment.TopEnd)
                            .padding(
                                top = 16.dp,
                                end = 16.dp,
                            ).clickable { onCloseClick() },
                )
            }

            // Индикаторы шагов - компактно
            Box(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                // Фиксированный отступ вместо веса
                contentAlignment = Alignment.Center,
            ) {
                AnimatedStepIndicator(
                    currentStep = currentStep,
                    totalSteps = 4,
                    activeColor = accentColor,
                    inactiveColor = Color(0xFFD9A08E),
                )
            }

            // Минимальный отступ перед кнопкой
            Spacer(modifier = Modifier.weight(2f))

            // Кнопка в нижней части
            Button(
                onClick = onContinueClick,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 8.dp),
                shape = RoundedCornerShape(80.dp),
                colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
            ) {
                Text(
                    text = buttonText,
                    fontSize = 17.sp,
                    fontFamily = sfProTextMedium,
                    color = Color.White,
                )
            }
        }
    }
}

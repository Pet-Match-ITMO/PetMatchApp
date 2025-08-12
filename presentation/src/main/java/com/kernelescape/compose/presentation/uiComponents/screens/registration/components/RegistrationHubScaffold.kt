package com.kernelescape.compose.presentation.uiComponents.screens.registration.components

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R

@Composable
fun RegistrationScaffold(
    buttonText: String? = null,
    onContinueClick: (() -> Unit)? = null,
    onCloseClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val sfProTextMedium = FontFamily(Font(R.font.sf_pro_text_regular, weight = FontWeight.Medium))

    Box(
        modifier =
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(all = 4.dp)
    ) {
        // Основная колонка с контентом
        Column(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Контент экрана (иллюстрация, заголовок, подзаголовок) - больше места
            Box(
                modifier =
                Modifier
                    .fillMaxWidth()
                    .weight(if (buttonText != null) 3f else 1f)
                    .padding(top = 24.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                content()
            }

            // Минимальный отступ перед кнопкой (только если есть кнопка)
            if (buttonText != null) {
                Spacer(modifier = Modifier.weight(2f))
            }

            // Кнопка в нижней части (показываем только если передан текст и обработчик)
            if (buttonText != null && onContinueClick != null) {
                Button(
                    onClick = onContinueClick,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Text(
                        text = buttonText,
                        fontSize = 17.sp,
                        fontFamily = sfProTextMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

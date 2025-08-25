package com.kernelescape.compose.presentation.uiComponents.screens.onboarding.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Компонент для отображения анимированных индикаторов шагов онбординга
 *
 * @param currentStep текущий шаг (нумерация начинается с 1)
 * @param totalSteps общее количество шагов
 * @param activeColor цвет активного индикатора
 * @param inactiveColor цвет неактивных индикаторов
 */
@Composable
fun AnimatedStepIndicator(
    currentStep: Int,
    totalSteps: Int = 4,
    activeColor: Color = MaterialTheme.colorScheme.secondary,
    inactiveColor: Color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f)
) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (step in 1..totalSteps) {
            // Анимация ширины индикатора
            val width by animateDpAsState(
                targetValue = if (step == currentStep) 18.dp else 8.dp,
                animationSpec =
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                ),
                label = "Width Animation"
            )

            // Анимация цвета индикатора
            val color by animateColorAsState(
                targetValue = if (step == currentStep) activeColor else inactiveColor,
                animationSpec = tween(durationMillis = 300),
                label = "Color Animation"
            )

            val actualWidth = width

            // Индикатор шага
            Box(
                modifier =
                Modifier
                    .width(actualWidth)
                    .height(8.dp)
                    .clip(CircleShape)
                    .background(color = color)
            )

            // Добавляем пробел между индикаторами, кроме последнего
            if (step < totalSteps) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

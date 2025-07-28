package com.kernelescape.compose.presentation.uiComponents.screens.onboarding

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
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
    activeColor: Color = Color(0xFFDB644E),
    inactiveColor: Color = Color(0xFFD9A08E)
) {
    // Дополнительная анимация для более заметного эффекта
    val infiniteTransition = rememberInfiniteTransition(label = "Pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.05f,
        animationSpec = infiniteRepeatable(
            animation = tween(800),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Scale"
    )
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        for (step in 1..totalSteps) {
            // Анимация ширины индикатора
            val width by animateDpAsState(
                targetValue = if (step == currentStep) 18.dp else 8.dp,
                animationSpec = spring(
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
            
            val actualWidth = if (step == currentStep) width * scale else width
            
            // Индикатор шага
            Box(
                modifier = Modifier
                    .width(actualWidth)
                    .height(8.dp)
                    .clip(CircleShape)
                    .background(color)
            )
            
            // Добавляем пробел между индикаторами, кроме последнего
            if (step < totalSteps) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedStepIndicatorPreview() {
    Column(Modifier.padding(16.dp)) {
        for (i in 1..4) {
            AnimatedStepIndicator(currentStep = i)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
} 
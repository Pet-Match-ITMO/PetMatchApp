package com.kernelescape.compose.presentation.uiComponents.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnboardingStep3Screen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF5F5F5F5))
            .clip(RoundedCornerShape(24.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            StatusBar()

            Spacer(modifier = Modifier.height(24.dp))

            // Illustration
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.onboarding_illustration),
                    contentDescription = "Onboarding Illustration",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )

                // Close button
                IconButton(
                    onClick = { /* TODO */ },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_close_circle),
                        contentDescription = "Close",
                        tint = Color(0xFFDB6433),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = "Раздел с советами",
                fontSize = 27.sp,
                fontFamily = FontFamily(Font(R.font.playfair_display_black)),
                color = Color(0xFF2C3138),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Subtitle
            Text(
                text = "Собрали для вас полезную информацию по социализации и уходу за питомцами",
                fontSize = 15.sp,
                fontFamily = FontFamily.Default,
                color = Color(0xFF2A3138),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Step indicators
            StepIndicators(currentStep = 3, totalSteps = 4)

            Spacer(modifier = Modifier.weight(1f))

            // Button
            ButtonGroup()
        }
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "12:48",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF2A3138)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cellular),
                contentDescription = null,
                tint = Color(0xFF2A3138),
                modifier = Modifier.size(17.dp, 10.67.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_wifi),
                contentDescription = null,
                tint = Color(0xFF2A3138),
                modifier = Modifier.size(15.27.dp, 10.97.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_battery),
                contentDescription = null,
                tint = Color(0xFF2A3138),
                modifier = Modifier.size(25.dp, 11.33.dp)
            )
        }
    }
}

@Composable
fun StepIndicators(currentStep: Int, totalSteps: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..totalSteps) {
            val isCurrentStep = i == currentStep
            Box(
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .height(8.dp)
                    .width(if (isCurrentStep) 18.dp else 8.dp)
                    .clip(CircleShape)
                    .background(
                        if (isCurrentStep) Color(0xFFDB6433) else Color(0xFFD9A08E)
                    )
            )
        }
    }
}

@Composable
fun ButtonGroup() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xF5F5F5F5))
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(80.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFF35A2AB)
            )
        ) {
            Text(
                text = "Далее",
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Home indicator
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(134.dp)
                    .height(5.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color(0xFF2A3138))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingStep3Preview() {
    OnboardingStep3Screen()
}
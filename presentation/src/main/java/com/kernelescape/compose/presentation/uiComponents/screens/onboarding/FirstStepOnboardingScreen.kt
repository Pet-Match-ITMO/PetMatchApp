package com.kernelescape.compose.presentation.uiComponents.screens.onboarding

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun OnboardingScreen1(
    onContinueClick: () -> Unit = {},
    onCloseClick: () -> Unit = {}
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val isLandscape = screenWidth > screenHeight

    // Fonts and Colors
    val playfairDisplayBlack = FontFamily(Font(R.font.playfair_display, weight = FontWeight.Black))
    val sfProTextRegular = FontFamily(Font(R.font.sf_pro_text_regular))
    val sfProTextMedium = FontFamily(Font(R.font.sf_pro_text_regular, weight = FontWeight.Medium))
    
    val backgroundColor = Color(0xFFF4F4F4)
    val primaryColor = Color(0xFF35A2AB)
    val accentColor = Color(0xFFDB644E)
    val textColor = Color(0xFF2A3138)
    val secondaryTextColor = Color(0xFF2D343D)

    // Main Container
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clip(RoundedCornerShape(24.dp))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Status Bar
            Spacer(modifier = Modifier.height(44.dp))

            // Gap
            Spacer(modifier = Modifier.height(24.dp))

            // Content area
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Illustration
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(if (isLandscape) 160.dp else 240.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.onboarding_first_step_illustration),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxWidth(if (isLandscape) 0.6f else 0.8f)
                                .padding(horizontal = 16.dp)
                        )
                    }

                    // Gap
                    Spacer(modifier = Modifier.height(24.dp))

                    // Title
                    Text(
                        text = "Добро пожаловать!",
                        fontSize = 27.sp,
                        fontFamily = playfairDisplayBlack,
                        color = textColor,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        textAlign =  TextAlign.Center
                    )

                    // Gap
                    Spacer(modifier = Modifier.height(16.dp))

                    // Subtitle
                    Text(
                        text = "В приложении вы найдёте питомцев из приютов, ожидающих любящих хозяев",
                        fontSize = 15.sp,
                        fontFamily = sfProTextRegular,
                        color = secondaryTextColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                }
            }

            // Stepped Indicator
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // Only show first step as active
                Box(
                    modifier = Modifier
                        .width(18.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(accentColor)
                )
            }

            Spacer(modifier = Modifier.weight(0.1f))

            // Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .padding(horizontal = 20.dp, vertical = 16.dp)
            ) {
                Button(
                    onClick = onContinueClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(80.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryColor
                    )
                ) {
                    Text(
                        text = "Далее",
                        fontSize = 17.sp,
                        fontFamily = sfProTextMedium,
                        color = Color.White
                    )
                }
            }

            // Home Indicator
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(28.dp)
                    .background(backgroundColor),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(134.dp)
                        .height(5.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(textColor)
                )
            }
        }

        // Close button (FAB)
        FloatingActionButton(
            onClick = onCloseClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 78.dp, end = 20.dp),
            containerColor = Color.White,
            contentColor = accentColor,
            shape = CircleShape
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close_circle),
                contentDescription = "Close",
                tint = accentColor,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen1Preview() {
    OnboardingScreen1()
}

@Preview(showBackground = true, widthDp = 812, heightDp = 375)
@Composable
fun OnboardingScreen1LandscapePreview() {
    OnboardingScreen1()
}
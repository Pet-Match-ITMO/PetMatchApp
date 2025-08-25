package com.kernelescape.compose.presentation.uiComponents.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(80.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontFamily = sfProTextMedium,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Composable
fun CustomTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontFamily = sfProTextMedium,
            color = Color(0xFF2A3138)
        )
    }
}

@Composable
fun ResetButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(80.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFD9E9EB),
            contentColor = Color.Black
        )
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.sp,
            fontFamily = sfProTextMedium
        )
    }
}

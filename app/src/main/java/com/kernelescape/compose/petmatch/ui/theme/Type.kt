package com.kernelescape.compose.petmatch.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R

/**
 * Playfair Display - основной шрифт для заголовков
 * Использует отдельные файлы для Normal и Black весов
 */
val PlayfairDisplayFontFamily =
    FontFamily(
        Font(R.font.playfair_display, weight = FontWeight.Normal),
        Font(R.font.playfair_display_black, weight = FontWeight.Black) // Используем отдельный файл для Black веса
    )

/**
 * SF Pro Text - шрифт для основного текста и подзаголовков
 * Поддерживает FontWeight.Normal (400)
 */
val SfProTextFontFamily =
    FontFamily(
        Font(R.font.sf_pro_text_regular, weight = FontWeight.Normal) // weight 400
    )

// Set of Material typography styles to start with
val Typography =
    Typography(
        bodyLarge =
        TextStyle(
            fontFamily = SfProTextFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.5.sp
        ),
        titleLarge =
        TextStyle(
            fontFamily = PlayfairDisplayFontFamily,
            fontWeight = FontWeight.Black,
            fontSize = 27.sp,
            lineHeight = 32.sp,
            letterSpacing = 0.sp
        ),
        titleMedium =
        TextStyle(
            fontFamily = SfProTextFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp
        )
    )

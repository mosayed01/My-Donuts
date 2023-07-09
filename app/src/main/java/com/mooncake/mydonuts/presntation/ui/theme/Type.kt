package com.mooncake.mydonuts.presntation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 54.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Bold
    ),
    headlineLarge = TextStyle(
        fontSize = 30.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold
    ),
    titleMedium = TextStyle(
        fontSize = 18.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold
    ),
    labelMedium = TextStyle(
        fontSize = 16.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Normal
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Normal
    ),
    bodyLarge = TextStyle(
        fontSize = 14.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.Medium
    )
)
package com.zet.desygn.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = AppLightColorTheme.toColorScheme()

// I`m not interested in dynamic colors
@Composable
fun AppTheme(content: @Composable () -> Unit) {

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content,
    )
}

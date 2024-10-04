package com.zet.desygn.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

interface ColorTheme {
    val background: Color
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val surface: Color
}

object AppLightColorTheme : ColorTheme {
    override val background = Honeydew
    override val primary = CaribbeanGreen
    override val secondary = LightBlue
    override val tertiary = OceanBlue
    override val surface = LightGreen

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */

    fun toColorScheme() = lightColorScheme(
        primary = primary,
        secondary = secondary,
        tertiary = tertiary,
        background = background,
        surface = surface,
    )
}

private val Honeydew = Color(0xFFF1FFF3)
private val LightGreen = Color(0xFFDFF7E2)
private val CaribbeanGreen = Color(0xFF00D09E)
private val Cyprus = Color(0xFF0E3E3E)
private val FenceGreen = Color(0xFF052224)
private val Void = Color(0xFF031314)
private val LightBlue = Color(0xFF6DB6FE)
private val VividBlue = Color(0xFF3299FF)
private val OceanBlue = Color(0xFF0068FF)

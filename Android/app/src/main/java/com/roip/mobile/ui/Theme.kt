package com.roip.mobile.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.roip.mobile.data.AccentColor

private val LightColors = lightColorScheme(
    primary = Color(0xFF0E6B57),
    onPrimary = Color(0xFFFFFFFF),
    secondary = Color(0xFF7A5C00),
    onSecondary = Color(0xFFFFFFFF),
    tertiary = Color(0xFF365CA8),
    background = Color(0xFFEDF3EF),
    surface = Color(0xFFF8FBF8),
    surfaceVariant = Color(0xFFDDE7E1),
    onSurface = Color(0xFF151916),
    onSurfaceVariant = Color(0xFF505950),
    outline = Color(0xFF6A776F),
    error = Color(0xFFB3261E)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF66D3B2),
    onPrimary = Color(0xFF00382B),
    secondary = Color(0xFFE2C36B),
    onSecondary = Color(0xFF3C2F00),
    tertiary = Color(0xFFAFC6FF),
    background = Color(0xFF040706),
    surface = Color(0xFF0A100D),
    surfaceVariant = Color(0xFF13211B),
    onSurface = Color(0xFFF0FAF4),
    onSurfaceVariant = Color(0xFFAFC3B8),
    outline = Color(0xFF5B6C63),
    error = Color(0xFFFFB4AB)
)

private val RoipTypography = Typography(
    headlineMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 34.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 26.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    )
)

@Composable
fun RoipTheme(
    accentColor: AccentColor = AccentColor.GREEN,
    content: @Composable () -> Unit
) {
    val dark = isSystemInDarkTheme()
    val accent = Color(if (dark) accentColor.darkPrimary else accentColor.lightPrimary)
    val colors = (if (dark) DarkColors else LightColors).copy(
        primary = accent,
        secondary = accent,
        onPrimary = if (dark) Color(0xFF001F18) else Color.White,
        onSecondary = if (dark) Color(0xFF001F18) else Color.White
    )
    MaterialTheme(
        colorScheme = colors,
        typography = RoipTypography,
        content = content
    )
}

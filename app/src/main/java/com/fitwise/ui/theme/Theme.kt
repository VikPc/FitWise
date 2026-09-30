package com.fitwise.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = TextPrimary,
    primaryContainer = GreenContainer,
    onPrimaryContainer = TextPrimary,
    background = BackgroundLight,
    surface = SurfaceWhite,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary
)

@Composable
fun FitWiseTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}

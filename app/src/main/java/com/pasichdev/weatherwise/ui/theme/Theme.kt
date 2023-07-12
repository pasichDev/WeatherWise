package com.pasichdev.weatherwise.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    outline = ColorOutline,
    background = ColorBackgroundDark,
    onBackground = Color(0xFFFFFFFF),
)


@Composable
fun WeatherWiseTheme(
    darkTheme: Boolean = true,
    colorNavigationDefault: Boolean = false,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val colorScheme = DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            systemUiController.setStatusBarColor(
                color = SystemGradienTwoTest,
                darkIcons = !darkTheme
            )
            systemUiController.setNavigationBarColor(
                color = if (colorNavigationDefault) colorScheme.surfaceVariant else colorScheme.background,
                darkIcons = !darkTheme
            )

        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
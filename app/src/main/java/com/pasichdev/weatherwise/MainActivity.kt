package com.pasichdev.weatherwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pasichdev.weatherwise.ui.components.ToolbarMainActivity
import com.pasichdev.weatherwise.ui.screen.main.MainDisplayWeather
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherWiseTheme {
                Scaffold(topBar = { ToolbarMainActivity() }) {
                    MainDisplayWeather(modifier = Modifier.padding(it))
                }

            }
        }
    }
}

package com.pasichdev.weatherwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pasichdev.weatherwise.ui.HOME_SCREEN
import com.pasichdev.weatherwise.ui.OTHER_WEATHER_SCREEN
import com.pasichdev.weatherwise.ui.screen.main.screen.ToolbarMainActivity
import com.pasichdev.weatherwise.ui.screen.main.HomeScreenWeather
import com.pasichdev.weatherwise.ui.screen.otherweather.OtherWeather
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherWiseTheme {
                MainScreen()
            }
            }
        }
    }

@OptIn( ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    Scaffold(topBar = { ToolbarMainActivity() }) {
        NavigationGraph(navController = navController, modifier.padding(it))
    }
}


@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = HOME_SCREEN) {
        composable(HOME_SCREEN) {
            HomeScreenWeather(navController, modifier)
        }
        composable(OTHER_WEATHER_SCREEN) {
            OtherWeather(modifier = modifier)


        }


    }
}
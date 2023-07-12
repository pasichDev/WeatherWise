package com.pasichdev.weatherwise.ui.screen.otherweather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.pasichdev.weatherwise.data.model.ForecastDay
import com.pasichdev.weatherwise.ui.screen.components.ToastNotRelease
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.NextDayItem
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.ToolbarOther
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.WeatherTomorrowDisplay
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest

@Composable
fun OtherWeather(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: OtherViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    Scaffold(topBar = {
        ToolbarOther(listener = object : ToolBarListener {
            override fun back() {
                navController.popBackStack()
            }

            override fun more() = ToastNotRelease(context)
        })
    }) {

        Column(
            modifier = modifier
                .padding(it)
                .fillMaxHeight()
                .fillMaxWidth()


        ) {
            InfoTomorrowWeather(state = state)
            state.currentDay?.forecast?.forecastdays?.let { list -> NextDaysWeather(listDays = list) }


        }

    }
}


@Composable
fun InfoTomorrowWeather(modifier: Modifier = Modifier, state: OtherState) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(SystemGradienTwoTest, SystemTest),
                    startY = 0.2f,
                    endY = Float.POSITIVE_INFINITY,
                    tileMode = TileMode.Clamp
                ),
                shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp),

                )


    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            state.currentDay?.forecast?.forecastdays?.let {

                WeatherTomorrowDisplay(tomorrowWeather = it[0])

            }
        }

    }
}

@Composable
fun NextDaysWeather(listDays: List<ForecastDay>) {

    LazyColumn {
        items(listDays.size) { index ->

            if (index >= 2) {
                val dayWeather = listDays[index].day

                if (dayWeather != null) {
                    NextDayItem(
                        dayData = listDays[index].date,
                        iconWeatherDay = dayWeather.condition.conditionWeatherIcon,
                        conditionWeatherDay = dayWeather.condition.conditionWeatherText,
                        maxTemp = dayWeather.maxtemp_c.toInt(),
                        minTemp = dayWeather.mintemp_c.toInt()
                    )
                }
            }
        }
    }
}

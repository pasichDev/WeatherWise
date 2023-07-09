package com.pasichdev.weatherwise.ui.screen.otherweather

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pasichdev.weatherwise.data.model.ForecastDay
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.NextDayItem
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.ToolbarOther
import com.pasichdev.weatherwise.ui.screen.otherweather.screen.WeatherTomorrowDisplay
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherWeather(modifier: Modifier = Modifier, navController: NavHostController, viewModel: OtherViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(topBar = { ToolbarOther(listener = object : ToolBarListener{
        override fun back() {
          navController.popBackStack()
        }

        override fun more() {
            TODO("Not yet implemented")
        }
    }) }) {

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
                Log.wtf(TAG, "InfoTomorrowWeather: "+it.size )
                Log.wtf(TAG, "InfoTomorrowWeather: "+it.get(0).toString() )
                if (it.size >= 2) {
                    WeatherTomorrowDisplay(tomorrowWeather = it[0])
                } else {
                    // Handle the case when there are not enough forecast days
                }
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

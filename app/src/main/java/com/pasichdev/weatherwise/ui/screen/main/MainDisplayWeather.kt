package com.pasichdev.weatherwise.ui.screen.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.components.HourWeatherCard
import com.pasichdev.weatherwise.ui.components.ImageWeatherMain
import com.pasichdev.weatherwise.ui.components.StatusLoadingInfo
import com.pasichdev.weatherwise.ui.components.WeatherDayInfoDisplay
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import kotlinx.coroutines.launch

// TODO: 1. Додати суікси для перекладів. 2. Зробити список на всю сторінку 

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainDisplayWeather(modifier: Modifier = Modifier, viewModel: MainViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()
    var selectedIndex: Int = 8
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(SystemGradienTwoTest, SystemTest),
                        startY = 0.2f,
                        endY = Float.POSITIVE_INFINITY,
                        tileMode = TileMode.Clamp
                    ),
                    shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp)

                )

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                StatusLoadingInfo(modifier = modifier)
                ImageWeatherMain()
                state.currentDay?.let { WeatherDayInfoDisplay(currentWeather = it) }

            }


        }

      /*  Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 40.dp)
        ) {

       */

            Column( modifier = Modifier.padding(horizontal = 40.dp).padding(top = 20.dp)) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Text(
                        text = stringResource(id = R.string.Today),
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "14 днів ",
                            color = MaterialTheme.colorScheme.outline,
                            fontSize = 18.sp
                        )
                    }

                }




          ///  }
        }

        LazyRow(modifier = Modifier.padding(start = 40.dp), state = lazyListState) {
        //    state.currentDay?.forecast?.forecastday?.get(0)?.hour?.size?.let { size ->
            itemsIndexed(
                state.currentDay?.forecast?.forecastday?.get(0)?.hour ?: emptyList()) { index, item ->
                // Code for each item
                HourWeatherCard(weatherHours = item)
            }
              //  itemsIndexed(state.currentDay.forecast.forecastday.get(0).hour) {  index, item ->
             /*   //    val hours = state.currentDay?.forecast?.forecastday?.get(0)?.hour
               //     hours?.get(item)?.let {
                    //     hourWeather ->
                        HourWeatherCard(weatherHours = item)
                //    }
                }

              */
          //  }
        }

    }
    // Сфокусуватися на обраному об'єкті при зміні selectedIndex
    coroutineScope.launch {
        lazyListState.scrollToItem(selectedIndex)
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
        MainDisplayWeather()
    }
}
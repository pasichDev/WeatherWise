package com.pasichdev.weatherwise.ui.screen.main

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.components.HourWeatherCard
import com.pasichdev.weatherwise.ui.components.ImageWeatherMain
import com.pasichdev.weatherwise.ui.components.StatusLoadingInfo
import com.pasichdev.weatherwise.ui.components.WeatherDayInfoDisplay
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.convertToDay
import com.pasichdev.weatherwise.utils.convertToHour
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// TODO: 1. Додати суікси для перекладів. 2. Зробити список на всю сторінку 

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MainDisplayWeather(modifier: Modifier = Modifier, viewModel: MainViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsStateWithLifecycle()

    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()

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

            Column( modifier = Modifier
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp)) {
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
                            fontSize = 18.sp,
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5F)
                        )
                    }

                }




        }


        val hoursList = state.currentDay?.forecast?.forecastday?.get(0)?.hour

        LazyRow(modifier = Modifier.padding(start = 40.dp), state = lazyListState) {
            if (hoursList != null) {
                items(hoursList.size) { index ->
                    val item = hoursList[index]
                    val  isToday = containsCurrentTime(item.time)

                    Log.wtf(TAG, "MainDisplayWeather: "+isToday )


                    HourWeatherCard(weatherHours = item, selected = isToday)
                    coroutineScope.launch {
                        if (isToday) {
                            lazyListState.scrollToItem(index)
                        }
                    }
                }
            }


        }

    }

}


fun containsCurrentTime(dateWeather: String): Boolean
{
    val currentDateTime = LocalDateTime.now()

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    val formattedDateTime = currentDateTime.format(formatter)

    return convertToHour(dateWeather) == convertToHour(formattedDateTime) && convertToDay(dateWeather) == convertToDay(formattedDateTime)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
        MainDisplayWeather()
    }
}
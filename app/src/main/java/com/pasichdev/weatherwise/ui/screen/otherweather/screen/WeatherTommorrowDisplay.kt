package com.pasichdev.weatherwise.ui.screen.otherweather.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.data.model.ForecastDay
import com.pasichdev.weatherwise.ui.screen.components.InfoWeatherCard
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.getWeatherIcon

@Composable
fun WeatherTomorrowDisplay(
    modifier: Modifier = Modifier, tomorrowWeather: ForecastDay = ForecastDay()
) {
    val tomorrowDay = tomorrowWeather.day


    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
            ) {
                if (tomorrowDay != null) {
                    Image(
                        painter = painterResource(id = getWeatherIcon(tomorrowDay.condition.conditionWeatherCode)),
                        contentDescription = "WeatherIcon",
                        modifier = modifier.size(150.dp)
                    )
                }
            }

            Box(
                modifier = Modifier.weight(1f)
            ) {
                Column {
                    Text(
                        text = stringResource(id = R.string.tomorrow),
                        fontWeight = FontWeight.Light,
                        fontSize = 28.sp
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        if (tomorrowDay != null) {
                            Text(
                                text = tomorrowDay.avgtemp_c.toInt().toString(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 100.sp
                            )
                        }

                        if (tomorrowDay != null) {
                            Text(
                                text = "/" + tomorrowDay.maxtemp_c.toInt().toString() + "°",
                                fontWeight = FontWeight.Normal,
                                fontSize = 50.sp,
                                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                            )
                        }
                    }

                    if (tomorrowDay != null) {
                        Text(
                            text = tomorrowDay.condition.conditionWeatherText,
                            modifier.padding(top = 5.dp),
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 22.sp,
                                color = Color.White.copy(alpha = 0.4f)
                            )
                        )
                    }
                }
            }


        }


        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(20.dp)
        )
        Row(modifier = modifier.padding(bottom = 20.dp)) {
            if (tomorrowDay != null) {
                InfoWeatherCard(
                    infoOne = stringResource(id = R.string.kmh, tomorrowDay.maxwind_kph),
                    infoTwo = stringResource(id = R.string.wind),
                    R.drawable.wind
                )
            }
            if (tomorrowDay != null) {
                InfoWeatherCard(
                    infoOne = tomorrowDay.avghumidity.toString() + "%",
                    infoTwo = stringResource(id = R.string.Humidity),
                    R.drawable.humidity
                )
            }
            if (tomorrowDay != null) {
                InfoWeatherCard(
                    infoOne = tomorrowDay.daily_chance_of_rain.toString() + "%",
                    infoTwo = stringResource(id = R.string.ChanceOfRain),
                    R.drawable.rain
                )
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun WeatherDayInfoDisplayOnePreview() {
    WeatherWiseTheme {
        WeatherTomorrowDisplay()
    }
}
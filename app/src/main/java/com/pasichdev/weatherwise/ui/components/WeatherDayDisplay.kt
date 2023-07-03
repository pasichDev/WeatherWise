package com.pasichdev.weatherwise.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun WeatherDayInfoDisplay(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {
            Text(
                text = "22", fontWeight = FontWeight.Bold, fontSize = 120.sp
            )
            Text(
                text = "°",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 120.sp,
                color = Color.White.copy(alpha = 0.4f)
            )
        }
        Text(
            text = stringResource(id = R.string.thunderstorm),
            fontWeight = FontWeight.Light,
            fontSize = 28.sp
        )
        Text(
            text = getDataUser(), modifier.padding(top = 5.dp), style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.4f)
            )
        )
        Divider(
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(20.dp)
        )
        Row(modifier = modifier.padding(bottom = 20.dp)) {
            InfoWeatherCard(
                infoOne = "13 km/h", infoTwo = stringResource(id = R.string.wind), R.drawable.wind
            )
            InfoWeatherCard(
                infoOne = "24%",
                infoTwo = stringResource(id = R.string.Humidity),
                R.drawable.humidity
            )
            InfoWeatherCard(
                infoOne = "87%",
                infoTwo = stringResource(id = R.string.ChanceOfRain),
                R.drawable.rain
            )
        }
    }
}

@Composable
fun InfoWeatherCard(infoOne: String, infoTwo: String, icon: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 40.dp)
    ) {
        Image(painter = painterResource(id = icon), contentDescription = infoTwo)
        Text(
            text = infoOne, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
        )
        Text(
            text = infoTwo, style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.4f)
            )
        )
    }
}

private fun getDataUser():String{
    val currentDate = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("EEEE, d MMMM",  Locale.getDefault())
    return currentDate.format(formatter)

}

@Preview(showBackground = true)
@Composable
fun WeatherDayInfoDisplayOnePreview() {
    WeatherWiseTheme {
        WeatherDayInfoDisplay()
    }
}
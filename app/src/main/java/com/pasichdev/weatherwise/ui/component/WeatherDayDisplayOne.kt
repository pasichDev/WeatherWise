package com.pasichdev.weatherwise.ui.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme

@Composable
fun WeatherDayInfoDisplayOne(modifier: Modifier = Modifier){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row() {
            Text(text = "22",
                fontWeight = FontWeight.Bold,
                fontSize = 120.sp)
            Text(text = "°",
                fontWeight = FontWeight.ExtraLight,
                fontSize = 120.sp,
                color = Color.White.copy(alpha = 0.4f))
        }
        Text(text = "Thunderstorm",
            fontWeight = FontWeight.Light,
            fontSize = 28.sp)
        Text(text = "Monday, 14 May",
            modifier.padding(top = 5.dp),
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.4f)
            ))
        Divider(color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f),
            thickness = 0.5.dp, modifier = Modifier.padding(20.dp))
        Row(modifier = modifier.padding(bottom = 20.dp)) {
            InfoWeatherCard(infoOne = "13km/h", infoTwo = "Wind")
            InfoWeatherCard(infoOne = "24%", infoTwo = "Humidity")
            InfoWeatherCard(infoOne = "87%", infoTwo = "Chance of rain")
        }
    }
}

@Composable
fun InfoWeatherCard(infoOne: String, infoTwo: String){
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(horizontal = 40.dp)) {
        Icon(imageVector = Icons.Default.Check , contentDescription = "")
        Text(text = infoOne,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)
        Text(text = infoTwo,
            style = TextStyle(
            fontWeight = FontWeight.Light,
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.4f)
        ))
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherDayInfoDisplayOnePreview() {
    WeatherWiseTheme {
        WeatherDayInfoDisplayOne()
    }
}
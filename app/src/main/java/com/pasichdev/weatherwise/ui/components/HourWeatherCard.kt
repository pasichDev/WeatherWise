package com.pasichdev.weatherwise.ui.components

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.data.model.Hour
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.convertToTime
import com.pasichdev.weatherwise.utils.getDataUser
import com.pasichdev.weatherwise.utils.getDataUserCheck

// TODO: Порівнювати чи цей день, і  чи ця година наразі.
@Composable
fun HourWeatherCard(modifier: Modifier = Modifier, weatherHours: Hour) {
    Log.wtf(TAG, "DataUSer: Data Hour: "+ getDataUserCheck() +"/"+ weatherHours.time )
    OutlinedCard(shape = RoundedCornerShape(35.dp), modifier = Modifier.padding(end = 15.dp)) {
        Column(
            modifier = modifier.padding(horizontal = 15.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = weatherHours.temp_c.toInt().toString() + "°",
                modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold)
            AsyncImage(
                model = "https://" +weatherHours.condition.icon,
                contentDescription = null,
                modifier = modifier
                  //  .padding(vertical = 10.dp)
                    .size(60.dp)
            )

          /*  Image(
                painter = painterResource(id = R.drawable.weather_test),
                contentDescription = "WeatherIcon",
                modifier = modifier
                    .padding(vertical = 10.dp)
                    .size(50.dp)
            )

           */
            Text(text =convertToTime(weatherHours.time), modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
       // HourWeatherCard(weatherHours = WeatherHours())
    }
}
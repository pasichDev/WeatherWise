package com.pasichdev.weatherwise.ui.component

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pasichdev.weatherwise.R

@Composable
fun ImageWeatherMain(modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = R.drawable.weather_test_big),
        contentDescription = "WeatherIcon",
        modifier = modifier
            .padding(vertical = 20.dp)
            .size(250.dp)
    )
}
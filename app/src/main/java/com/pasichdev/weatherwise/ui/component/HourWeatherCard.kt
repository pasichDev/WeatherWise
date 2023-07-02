package com.pasichdev.weatherwise.ui.component

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
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme

@Composable
fun HourWeatherCard(modifier: Modifier = Modifier) {
    OutlinedCard(shape = RoundedCornerShape(30.dp)) {
        Column(
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "21°", modifier = modifier, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Image(
                painter = painterResource(id = R.drawable.weather_test),
                contentDescription = "WeatherIcon",
                modifier = modifier
                    .padding(vertical = 10.dp)
                    .size(60.dp)
            )
            Text(text = "8:00", modifier = modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
        HourWeatherCard()
    }
}
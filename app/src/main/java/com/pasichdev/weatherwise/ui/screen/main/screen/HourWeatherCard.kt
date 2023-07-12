package com.pasichdev.weatherwise.ui.screen.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pasichdev.weatherwise.data.model.Hour
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.convertToTime

@Composable
fun HourWeatherCard(modifier: Modifier = Modifier, weatherHours: Hour, selected: Boolean = false) {
    var paddingCard = 15.dp
    var textColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6F)
    var brush: Brush = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background
        )
    )

    if (selected) {
        paddingCard = 20.dp
        brush = Brush.verticalGradient(
            colors = listOf(SystemGradienTwoTest, SystemTest),
            startY = 0.2f,
            endY = Float.POSITIVE_INFINITY,
            tileMode = TileMode.Clamp
        )
        textColor = MaterialTheme.colorScheme.onBackground
    }


    OutlinedCard(shape = RoundedCornerShape(35.dp), modifier = Modifier.padding(end = 15.dp)) {


        Box(
            modifier = modifier.background(
                brush = brush
            )
        ) {
            Column(
                modifier = Modifier.padding(paddingCard),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = weatherHours.temp_c.toInt().toString() + "°",
                    modifier = modifier,
                    fontSize = 22.sp,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold
                )
                AsyncImage(
                    model = "https://" + weatherHours.condition.conditionWeatherIcon,
                    contentDescription = null,
                    modifier = modifier
                        .size(50.dp)
                )

                Text(
                    text = convertToTime(weatherHours.time), modifier = modifier,
                    color = textColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
    }
}
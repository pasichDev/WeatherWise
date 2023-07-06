package com.pasichdev.weatherwise.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pasichdev.weatherwise.data.model.Hour
import com.pasichdev.weatherwise.ui.theme.MAinDuvuderTest
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.convertToTime
import com.pasichdev.weatherwise.utils.getDataUserCheck

@Composable
fun HourWeatherCard(modifier: Modifier = Modifier, weatherHours: Hour, selected: Boolean = false) {
    var colorContainer = MaterialTheme.colorScheme.background
    var paddingCard = 15.dp

     if(selected){
         colorContainer = SystemGradienTwoTest
         paddingCard = 20.dp
     }


    OutlinedCard(shape = RoundedCornerShape(35.dp), modifier = Modifier.padding(end = 15.dp),
        colors = CardDefaults.outlinedCardColors(containerColor = colorContainer)) {
        Column(
            modifier = modifier.padding(paddingCard),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = weatherHours.temp_c.toInt().toString() + "°",
                modifier = modifier,
                fontSize = 22.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold)
            AsyncImage(
                model = "https://" +weatherHours.condition.icon,
                contentDescription = null,
                modifier = modifier
                    .size(60.dp)
            )

            Text(text = convertToTime(weatherHours.time), modifier = modifier, color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6F))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
    }
}
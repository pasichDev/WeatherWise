package com.pasichdev.weatherwise.ui.screen.otherweather.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.convertToSmallData

@Composable
fun NextDayItem(
    modifier: Modifier = Modifier,
    dayData: String = "12.05",
    iconWeatherDay: String = "",
    conditionWeatherDay: String = "Rain",
    maxTemp: Int = 0,
    minTemp: Int = 0
) {

    Row(
        modifier = modifier.padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = convertToSmallData(dayData), modifier = modifier.padding(start = 20.dp),
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
        )

        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AsyncImage(
                    model = "https://" + iconWeatherDay,
                    contentDescription = null,
                    modifier = modifier.padding(horizontal = 5.dp)
                        .size(40.dp)
                )

                Text(
                    text = conditionWeatherDay,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                )

            }
        }

        Row(modifier = modifier.padding(end = 20.dp)) {

            Text(text = "$maxTemp°", color = MaterialTheme.colorScheme.onBackground)
            Text(
                text = "/$minTemp°",
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
            )

        }


    }

}


@Preview(showBackground = true)
@Composable
fun NextDayItemPreview() {
    WeatherWiseTheme {
        NextDayItem()
    }
}
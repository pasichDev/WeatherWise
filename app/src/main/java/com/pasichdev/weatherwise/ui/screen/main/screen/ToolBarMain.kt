package com.pasichdev.weatherwise.ui.screen.main.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.screen.main.ToolBarMainListener
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.DEFAULT_LOCATION_WEATHER


@Composable
fun ToolbarMainActivity(modifier: Modifier = Modifier, locationWeather: String = DEFAULT_LOCATION_WEATHER, listener: ToolBarMainListener) {

    Row(
        modifier = modifier.background(color = SystemGradienTwoTest),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            modifier = modifier.padding(start = 20.dp),
            onClick = { listener.detailNews() }) {
            Icon(painter = painterResource(id = R.drawable.more_grid), contentDescription = "")
        }


        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                TextButton(onClick = { listener.searchCity() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.location),
                        contentDescription = "Location",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = locationWeather,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                }
            }
        }

        IconButton(modifier = modifier.padding(end = 20.dp), onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.more), contentDescription = "")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ToolbarMainActivityPreview() {
    WeatherWiseTheme {
        ToolbarMainActivity(listener = object : ToolBarMainListener {
            override fun searchCity() {
                TODO("Not yet implemented")
            }

            override fun detailNews() {
                TODO("Not yet implemented")
            }
        })
    }
}
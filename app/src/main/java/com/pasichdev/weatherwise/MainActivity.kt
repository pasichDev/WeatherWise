package com.pasichdev.weatherwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import com.pasichdev.weatherwise.ui.components.HourWeatherCard
import com.pasichdev.weatherwise.ui.components.ImageWeatherMain
import com.pasichdev.weatherwise.ui.components.StatusLoadingInfo
import com.pasichdev.weatherwise.ui.components.ToolbarMainActivity
import com.pasichdev.weatherwise.ui.components.WeatherDayInfoDisplay
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherWiseTheme {

                Scaffold(topBar = { ToolbarMainActivity() }) {
                    Greeting(modifier = Modifier.padding(it))
                }


            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(SystemGradienTwoTest, SystemTest),
                        startY = 0.2f,
                        endY = Float.POSITIVE_INFINITY,
                        tileMode = TileMode.Clamp
                    ),
                    shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp)

                )

        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                StatusLoadingInfo(modifier = modifier)
                ImageWeatherMain()
                WeatherDayInfoDisplay()
            }


        }

        Box(
            modifier = Modifier
                .fillMaxHeight(1f)
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 40.dp)
        ) {

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {

                    Text(
                        text = "Today",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = "7 days >",
                            color = MaterialTheme.colorScheme.outline,
                            fontSize = 14.sp
                        )
                    }


                }
                Box(
                    modifier.fillMaxWidth()
                ) {
                    HourWeatherCard()
                }


            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherWiseTheme {
        Greeting()
    }
}
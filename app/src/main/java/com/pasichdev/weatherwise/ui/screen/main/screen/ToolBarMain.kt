package com.pasichdev.weatherwise.ui.screen.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun ToolbarMainActivity(modifier: Modifier = Modifier) {

    Row(
        modifier = modifier.padding(horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = { }) {
            Icon(painter = painterResource(id = R.drawable.more_grid), contentDescription = "")
        }


        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = modifier.padding(end = 5.dp),
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = ""
                )
                Text(text = "Лондон", fontWeight = FontWeight.Bold, fontSize = 26.sp)
            }
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.more), contentDescription = "")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ToolbarMainActivityPreview() {
    WeatherWiseTheme {
        ToolbarMainActivity()
    }
}
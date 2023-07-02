package com.pasichdev.weatherwise.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme

@Composable

fun StatusRefresh(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(5.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.point),
                tint = Color.Yellow,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 5.dp)
            )
            Text(text = "Updating", modifier = Modifier.padding(end = 5.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatusRefreshPreview() {
    WeatherWiseTheme {
        StatusRefresh()
    }
}
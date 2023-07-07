package com.pasichdev.weatherwise.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InfoWeatherCard(infoOne: String, infoTwo: String, icon: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 40.dp)
    ) {
        Image(painter = painterResource(id = icon), contentDescription = infoTwo)
        Text(
            text = infoOne, fontWeight = FontWeight.SemiBold, fontSize = 18.sp
        )
        Text(
            text = infoTwo, style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 16.sp,
                color = Color.White.copy(alpha = 0.4f)
            )
        )
    }
}

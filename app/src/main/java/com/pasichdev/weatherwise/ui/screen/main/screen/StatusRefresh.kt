package com.pasichdev.weatherwise.ui.screen.main.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.theme.WeatherWiseTheme
import com.pasichdev.weatherwise.utils.DATA_REFRESH_STATUS_LOADING
import com.pasichdev.weatherwise.utils.DATA_REFRESH_STATUS_NO_CONNECTED
import com.pasichdev.weatherwise.utils.dataRefreshStatusColor
import com.pasichdev.weatherwise.utils.dataRefreshStatusStrings


@Composable
fun StatusLoadingInfo(
    modifier: Modifier = Modifier,
    dataRefreshStatus: Int = DATA_REFRESH_STATUS_LOADING,
    refreshConnected: () -> Unit = {}
) {

    Box(
        modifier = modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(5.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.point),
                tint = dataRefreshStatusColor[dataRefreshStatus - 1],
                contentDescription = "Update Check",
                modifier = Modifier
                    .padding(horizontal = 5.dp)
                    .size(5.dp)
            )
            Text(
                text = stringResource(id = dataRefreshStatusStrings[dataRefreshStatus - 1]),
                modifier = Modifier
                    .padding(end = 5.dp)
                    .clickable(
                        enabled = dataRefreshStatus == DATA_REFRESH_STATUS_NO_CONNECTED,
                        onClick = refreshConnected
                    ),
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 14.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StatusRefreshPreview() {
    WeatherWiseTheme {
        StatusLoadingInfo()
    }
}
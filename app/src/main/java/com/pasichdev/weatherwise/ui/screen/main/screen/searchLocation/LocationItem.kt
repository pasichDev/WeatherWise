package com.pasichdev.weatherwise.ui.screen.main.screen.searchLocation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.data.model.Location
import com.pasichdev.weatherwise.utils.getLocationParam

@Composable
fun LocationItem(modifier: Modifier = Modifier, location: Location, clickItem: () -> Unit) {

    Row(
        modifier = modifier
            .clickable(enabled = true, onClick = clickItem)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Icon(
            modifier = modifier.padding(horizontal = 10.dp),
            painter = painterResource(id = R.drawable.location),
            contentDescription = "Location",
        )
        Column(modifier = modifier.padding(10.dp)) {
            Text(
                text = location.name
            )
            Row {
                Text(
                    text = location.country + ", ",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.6f)
                )
                Text(
                    text = location.region+ ", ",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.6f)
                )
                Text(
                    text = getLocationParam(location),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(0.6f)
                )
            }


        }
    }


}

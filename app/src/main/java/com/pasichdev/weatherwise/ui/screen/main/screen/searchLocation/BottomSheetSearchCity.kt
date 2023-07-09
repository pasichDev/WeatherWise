package com.pasichdev.weatherwise.ui.screen.main.screen.searchLocation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.data.model.Location

@Composable
fun BottomSheetSearchLocation(
    modifier: Modifier = Modifier,
    searchText: String,
    locations: List<Location>,
    onLocationSelected: (Location) -> Unit,
    onLocationRefresh: (String) -> Unit,
) {
    var inputText by remember { mutableStateOf(searchText) }
    Column {

        LazyColumn(contentPadding = PaddingValues(horizontal = 20.dp)) {
            items(locations.size) {
                LocationItem(location = locations[it],
                    clickItem = { onLocationSelected.invoke(locations[it]) })
            }
        }
        TextField(modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
            value = inputText,
            shape = RoundedCornerShape(20.dp),
            onValueChange = { newSearchText ->
                inputText = newSearchText
                if (newSearchText.length >= 2) onLocationRefresh(newSearchText)
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            label = { Text(stringResource(id = R.string.hintCitySearch)) })
    }
}
package com.pasichdev.weatherwise.ui.screen.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.pasichdev.weatherwise.R
import com.pasichdev.weatherwise.ui.OTHER_WEATHER_SCREEN
import com.pasichdev.weatherwise.ui.screen.components.ToastNotRelease
import com.pasichdev.weatherwise.ui.screen.main.screen.HourWeatherCard
import com.pasichdev.weatherwise.ui.screen.main.screen.StatusLoadingInfo
import com.pasichdev.weatherwise.ui.screen.main.screen.ToolbarMainActivity
import com.pasichdev.weatherwise.ui.screen.main.screen.WeatherDayInfoDisplay
import com.pasichdev.weatherwise.ui.screen.main.screen.searchLocation.BottomSheetSearchLocation
import com.pasichdev.weatherwise.ui.theme.SystemGradienTwoTest
import com.pasichdev.weatherwise.ui.theme.SystemTest
import com.pasichdev.weatherwise.utils.convertToDay
import com.pasichdev.weatherwise.utils.convertToHour
import com.pasichdev.weatherwise.utils.getWeatherIcon
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("CoroutineCreationDuringComposition", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreenWeather(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val skipPartiallyExpanded by remember { mutableStateOf(true) }
    val edgeToEdgeEnabled by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )


    Scaffold(topBar = {
        ToolbarMainActivity(locationWeather = state.locationWeather.name,
            listener = object : ToolBarMainListener {
                override fun searchCity() {

                    openBottomSheet = !openBottomSheet
                }

                override fun detailNews() = ToastNotRelease(context)
                override fun more() = ToastNotRelease(context)
            })
    }) { it ->

        Column(
            modifier = modifier
                .padding(it)
                .fillMaxHeight()
                .fillMaxWidth()


        ) {
            InfoCurrentWeather(state = state, refreshConnected = { viewModel.updateFetch() })
            TodayWeather(navHostController = navHostController, state = state)


            if (openBottomSheet) {
                val windowInsets =
                    if (edgeToEdgeEnabled) WindowInsets(0) else BottomSheetDefaults.windowInsets

                ModalBottomSheet(
                    onDismissRequest = { openBottomSheet = false },
                    sheetState = bottomSheetState,
                    windowInsets = windowInsets
                ) {
                    BottomSheetSearchLocation(searchText = "",
                        locationSelect = state.locationWeather,
                        locations = state.listCityWeather,
                        onLocationSelected = {
                            viewModel.updateLocationWeather(it)
                            openBottomSheet = false
                        },
                        onLocationRefresh = {
                            viewModel.fetchResultLocationSearch(it)
                        })
                }
            }

        }

    }


}

@Composable
fun InfoCurrentWeather(
    modifier: Modifier = Modifier, state: MainState, refreshConnected: () -> Unit = {}
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
                shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp),

                )


    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            StatusLoadingInfo(
                modifier = modifier,
                dataRefreshStatus = state.dataRefreshStatus,
                refreshConnected = refreshConnected
            )

            state.currentDay?.let {
                Image(
                    painter = painterResource(id = getWeatherIcon(it.current.condition.conditionWeatherCode)),
                    contentDescription = "WeatherIcon",
                    modifier = modifier
                        .padding(vertical = 20.dp)
                        .size(250.dp)
                )
                WeatherDayInfoDisplay(currentWeather = it)
            }

        }


    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TodayWeather(
    navHostController: NavHostController, modifier: Modifier = Modifier, state: MainState
) {
    val currentDateTime =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    val coroutineScope = rememberCoroutineScope()
    val lazyListState = rememberLazyListState()

    Column(
        modifier = modifier
            .padding(horizontal = 40.dp)
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {

            Text(
                text = stringResource(id = R.string.Today),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Box(
                Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(onClick = {
                    navHostController.navigate(OTHER_WEATHER_SCREEN) {

                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

                ) {
                    Text(
                        text = stringResource(id = R.string.otherDays),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5F)
                    )
                }
            }

        }


    }


    val hoursList = state.currentDay?.forecast?.forecastdays?.get(0)?.hour

    LazyRow(modifier = Modifier.padding(start = 40.dp), state = lazyListState) {
        if (hoursList != null) {
            items(hoursList.size) { index ->
                val item = hoursList[index]
                val isToday = containsCurrentTime(item.time, currentDateTime)

                if (convertToHour(item.time) >= convertToHour(currentDateTime)) {
                    HourWeatherCard(weatherHours = item, selected = isToday)
                }
                coroutineScope.launch {
                    if (isToday) {
                        lazyListState.scrollToItem(index)
                    }
                }
            }
        }

    }
}


fun containsCurrentTime(dateWeather: String, currentDateTime: String): Boolean {

    return convertToHour(dateWeather) == convertToHour(currentDateTime) && convertToDay(dateWeather) == convertToDay(
        currentDateTime
    )
}



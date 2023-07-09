package com.pasichdev.weatherwise.ui.screen.main

import com.pasichdev.weatherwise.data.model.Location
import com.pasichdev.weatherwise.data.model.Weather
import com.pasichdev.weatherwise.utils.DATA_REFRESH_STATUS_LOADING

data class MainState(
    val currentDay: Weather? = null,
    val dataRefreshStatus: Int = DATA_REFRESH_STATUS_LOADING,
    val listCityWeather: List<Location> = emptyList()
)

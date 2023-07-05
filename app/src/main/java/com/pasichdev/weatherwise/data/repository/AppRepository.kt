package com.pasichdev.weatherwise.data.repository

import com.pasichdev.weatherwise.data.model.WeatherCurrentDay

interface AppRepository {

    suspend fun getWeatherCurrentDay(country: String): WeatherCurrentDay
}
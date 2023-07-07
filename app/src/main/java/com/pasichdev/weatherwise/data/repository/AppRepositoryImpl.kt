package com.pasichdev.weatherwise.data.repository

import com.pasichdev.weatherwise.data.model.WeatherCurrentDay
import com.pasichdev.weatherwise.data.network.ApiService
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AppRepository  {
    override suspend fun getWeatherCurrentDay(country: String): WeatherCurrentDay {
        return apiService.getWeatherCurrentDay(country = country)
    }

    override suspend fun getWeatherOtherDays(country: String): WeatherCurrentDay {
        return apiService.getWeatherOtherDays(country = country)
    }
}
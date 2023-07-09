package com.pasichdev.weatherwise.data.repository

import com.pasichdev.weatherwise.data.model.Location
import com.pasichdev.weatherwise.data.model.Weather
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    suspend fun getWeatherCurrentDay(country: String): Weather

    suspend fun getResultSearchCity(location: String):  List<Location>

    fun getWeather(): Flow<Weather>
    suspend fun updateWeatherLocal(weather: Weather)

}
package com.pasichdev.weatherwise.data.repository

import com.pasichdev.weatherwise.data.LocalDatabase
import com.pasichdev.weatherwise.data.model.Weather
import com.pasichdev.weatherwise.data.network.ApiService
import java.util.Locale
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService, private val localDatabase: LocalDatabase
) : AppRepository {
    private val deviceLanguage = Locale.getDefault().language
    override suspend fun getWeatherCurrentDay(city: String) =
        apiService.getWeatherCurrentDay(location = city, lang = deviceLanguage)

    override suspend fun getResultSearchCity(location: String) =
        apiService.getSearchLocation(nameCity = location)

    override fun getWeather() = localDatabase.weatherDao.getWeather()

    override suspend fun updateWeatherLocal(weather: Weather) =
        localDatabase.weatherDao.updateWeather(weather)

}
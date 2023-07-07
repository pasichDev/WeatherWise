package com.pasichdev.weatherwise.data.network

import com.pasichdev.weatherwise.data.model.WeatherCurrentDay
import com.pasichdev.weatherwise.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


  @GET("forecast.json")
  suspend fun getWeatherCurrentDay(
    @Query("key") key: String = API_KEY,
    @Query("q") country: String = "London",
    @Query("lang") lang: String = "uk",
    @Query("days") days: Int = 1
  ): WeatherCurrentDay

  @GET("forecast.json")
  suspend fun getWeatherOtherDays(
    @Query("key") key: String = API_KEY,
    @Query("q") country: String = "London",
    @Query("lang") lang: String = "uk",
    @Query("days") days: Int = 14
  ): WeatherCurrentDay
}
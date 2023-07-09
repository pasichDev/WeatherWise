package com.pasichdev.weatherwise.data.network

import com.pasichdev.weatherwise.data.model.Location
import com.pasichdev.weatherwise.data.model.Weather
import com.pasichdev.weatherwise.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
  @GET("forecast.json")
  suspend fun getWeatherCurrentDay(
    @Query("key") key: String = API_KEY,
    @Query("q") country: String,
    @Query("lang") lang: String = "uk",
    @Query("days") days: Int = 14
  ): Weather

  @GET("search.json")
  suspend fun getSearchLocation(
    @Query("key") key: String = API_KEY,
    @Query("q") nameCity: String
  ): List<Location>

}
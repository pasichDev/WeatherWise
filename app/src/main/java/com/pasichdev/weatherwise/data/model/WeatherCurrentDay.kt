package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDay(
    @field:SerializedName("location") val location: City = City(),

    @field:SerializedName("current") val current: CurrentWeather = CurrentWeather(),

    @field:SerializedName("forecast") val forecast: Forecast = Forecast()
)

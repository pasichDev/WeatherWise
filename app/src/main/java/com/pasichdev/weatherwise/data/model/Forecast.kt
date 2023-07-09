package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName


data class Forecast(
  @field:SerializedName("forecastday") val forecastdays: List<ForecastDay> = emptyList()
)






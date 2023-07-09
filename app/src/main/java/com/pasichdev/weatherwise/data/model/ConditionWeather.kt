package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName

data class ConditionWeather(
    @field:SerializedName("text") val conditionWeatherText: String = "",
    @field:SerializedName("icon") val conditionWeatherIcon: String = "",
)

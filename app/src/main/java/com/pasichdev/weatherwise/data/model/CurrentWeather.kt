package com.pasichdev.weatherwise.data.model

data class CurrentWeather(
    val last_updated: String = "",
    val temp_c: Double = 0.0,
    val temp_f: Double = 0.0,
    val condition: ConditionWeather = ConditionWeather(),
    val wind_mph: Double = 0.0,
    val wind_kph: Double = 0.0,
    val humidity: Int = 0,
    val feelslike_c: Double = 0.0,
    val feelslike_f: Double = 0.0,
)



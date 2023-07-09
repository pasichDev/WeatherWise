package com.pasichdev.weatherwise.data.model


data class Hour(
    val time: String = "",
    val temp_c: Double = 0.0,
    val temp_f: Double = 0.0,
    val condition: ConditionWeather = ConditionWeather(),
    val wind_mph: Double = 0.0,
    val wind_kph: Double = 0.0,
    val chance_of_rain: Int = 0,
)
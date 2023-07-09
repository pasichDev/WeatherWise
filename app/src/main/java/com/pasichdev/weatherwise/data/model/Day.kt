package com.pasichdev.weatherwise.data.model


data class Day(
    val maxtemp_c: Double = 0.0,
    val maxtemp_f: Double = 0.0,
    val mintemp_c: Double = 0.0,
    val mintemp_f: Double = 0.0,
    val avgtemp_c: Double = 0.0,
    val avgtemp_f: Double = 0.0,
    val maxwind_mph: Double = 0.0,
    val maxwind_kph: Double = 0.0,
    val avghumidity: Double = 0.0,
    val daily_will_it_rain: Int = 0,
    val daily_chance_of_rain: Int = 0,
    val daily_will_it_snow: Int = 0,
    val daily_chance_of_snow: Int = 0,
    val condition: ConditionWeather = ConditionWeather(),
)
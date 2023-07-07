package com.pasichdev.weatherwise.data.model


data class Forecast(
    val forecastday: List<ForecastDay> = listOf()
)

data class ForecastDay(
    val date: String = "",
    val date_epoch: Long = 0,
    val day: Day? = Day(),
    val astro: Astro? = Astro(),
    val hour: List<Hour>? = emptyList()
)

data class Day(
    val maxtemp_c: Double = 0.0,
    val maxtemp_f: Double = 0.0,
    val mintemp_c: Double = 0.0,
    val mintemp_f: Double = 0.0,
    val avgtemp_c: Double = 0.0,
    val avgtemp_f: Double = 0.0,
    val maxwind_mph: Double = 0.0,
    val maxwind_kph: Double = 0.0,
    val totalprecip_mm: Double = 0.0,
    val totalprecip_in: Double = 0.0,
    val totalsnow_cm: Double = 0.0,
    val avgvis_km: Double = 0.0,
    val avgvis_miles: Double = 0.0,
    val avghumidity: Double = 0.0,
    val daily_will_it_rain: Int = 0,
    val daily_chance_of_rain: Int = 0,
    val daily_will_it_snow: Int = 0,
    val daily_chance_of_snow: Int = 0,
    val condition: Condition = Condition(),
    val uv: Double = 0.0
)

data class Astro(
    val sunrise: String = "",
    val sunset: String = "",
    val moonrise: String = "",
    val moonset: String = "",
    val moon_phase: String = "",
    val moon_illumination: String= "",
    val is_moon_up: Int = 0,
    val is_sun_up: Int = 0
)

data class Hour(
    val time_epoch: Long = 0,
    val time: String = "",
    val temp_c: Double = 0.0,
    val temp_f: Double  = 0.0,
    val is_day: Int = 0,
    val condition: Condition = Condition(),
    val wind_mph: Double  = 0.0,
    val wind_kph: Double = 0.0,
    val wind_degree: Int= 0,
    val wind_dir: String = "",
    val pressure_mb: Double = 0.0,
    val pressure_in: Double = 0.0,
    val precip_mm: Double = 0.0,
    val precip_in: Double = 0.0,
    val humidity: Int= 0,
    val cloud: Int= 0,
    val feelslike_c: Double = 0.0,
    val feelslike_f: Double = 0.0,
    val windchill_c: Double = 0.0,
    val windchill_f: Double = 0.0,
    val heatindex_c: Double = 0.0,
    val heatindex_f: Double = 0.0,
    val dewpoint_c: Double = 0.0,
    val dewpoint_f: Double = 0.0,
    val will_it_rain: Int = 0,
    val chance_of_rain: Int = 0,
    val will_it_snow: Int = 0,
    val chance_of_snow: Int = 0,
    val vis_km: Double= 0.0,
    val vis_miles: Double= 0.0,
    val gust_mph: Double= 0.0,
    val gust_kph: Double= 0.0,
    val uv: Double= 0.0
)

data class Condition(
    val text: String = "",
    val icon: String = "",
    val code: Int = 0
)


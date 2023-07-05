package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(

    @field:SerializedName("last_updated_epoch") val last_updated_epoch: Long = 0,
    @field:SerializedName("last_updated") val last_updated: String = "",
    @field:SerializedName("temp_c") val temp_c: Double = 0.0,
    @field:SerializedName("temp_f") val temp_f: Double = 0.0,
    @field:SerializedName("is_day") val is_day: Int = 1,
    @field:SerializedName("condition") val condition: ConditionWeather = ConditionWeather(),
    @field:SerializedName("wind_mph") val wind_mph: Double = 0.0,
    @field:SerializedName("wind_kph") val wind_kph: Double = 0.0,
    @field:SerializedName("wind_degree") val wind_degree: Int = 0,
    @field:SerializedName("wind_dir") val wind_dir: String = "",
    @field:SerializedName("pressure_mb") val pressure_mb: Double = 0.0,
    @field:SerializedName("pressure_in") val pressure_in: Double = 0.0,
    @field:SerializedName("precip_mm") val precip_mm: Double = 0.0,
    @field:SerializedName("precip_in") val precip_in: Double = 0.0,
    @field:SerializedName("humidity") val humidity: Int = 0,
    @field:SerializedName("cloud") val cloud: Int = 0,
    @field:SerializedName("feelslike_c") val feelslike_c: Double = 0.0,
    @field:SerializedName("feelslike_f") val feelslike_f: Double = 0.0,
    @field:SerializedName("vis_km") val vis_km: Double = 0.0,
    @field:SerializedName("vis_miles") val vis_miles: Double = 0.0,
    @field:SerializedName("uv") val uv: Double = 0.0,
    @field:SerializedName("gust_mph") val gust_mph: Double = 0.0,
    @field:SerializedName("gust_kph") val gust_kph: Double = 0.0,


    )



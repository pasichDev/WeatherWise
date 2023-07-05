package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName

data class ConditionWeather(

    @field:SerializedName("text") val text: String = "",
    @field:SerializedName("icon") val icon: String = "",
    @field:SerializedName("code") val code: Int = 0,
    @field:SerializedName("lat") val lat: String = "",
    @field:SerializedName("lon") val lon: String = "",
    @field:SerializedName("tz_id") val tz_id: String = "",
    @field:SerializedName("localtime_epoch") val localtime_epoch: Long = 0,
    @field:SerializedName("localtime") val localtime: String = "",
)

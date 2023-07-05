package com.pasichdev.weatherwise.data.model

import com.google.gson.annotations.SerializedName

data class City (

    @field:SerializedName("name") val nameCity: String = "",
    @field:SerializedName("region") val region: String = "",
    @field:SerializedName("country") val country: String = "",
    @field:SerializedName("lat") val lat: String = "",
    @field:SerializedName("lon") val lon: String = "",
    @field:SerializedName("tz_id") val tz_id: String = "",
    @field:SerializedName("localtime_epoch") val localtime_epoch: Long = 0,
    @field:SerializedName("localtime") val localtime: String = "",
        ) {
}



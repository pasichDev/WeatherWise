package com.pasichdev.weatherwise.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Weather(
    @PrimaryKey(autoGenerate = false) val weatherId: Long = 1,
    @field:SerializedName("location") val location: Location = Location(),

    @field:SerializedName("current") val current: CurrentWeather = CurrentWeather(),

    @field:SerializedName("forecast") val forecast: Forecast = Forecast()
)

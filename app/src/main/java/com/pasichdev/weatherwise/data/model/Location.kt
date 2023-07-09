package com.pasichdev.weatherwise.data.model

import androidx.room.Entity

@Entity
data class Location(
    val LocationId: Int = 1,
    val nameCity: String = "",
    val region: String = "",
    val country: String = "",
    val lat: String = "",
)
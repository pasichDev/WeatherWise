package com.pasichdev.weatherwise.data.model

import androidx.room.Entity

@Entity
data class Location(
    val name: String = "",
    val region: String = "",
    val country: String = "",
    val lat: String = "",
)
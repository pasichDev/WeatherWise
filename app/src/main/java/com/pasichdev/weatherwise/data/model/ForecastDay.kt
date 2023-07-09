package com.pasichdev.weatherwise.data.model


data class ForecastDay(
    val date: String = "",
    val date_epoch: Long = 0,
    val day: Day? = Day(),
    val hour: List<Hour>? = emptyList()
)
package com.pasichdev.weatherwise.utils

import androidx.compose.ui.graphics.Color
import com.pasichdev.weatherwise.R

const val DATA_REFRESH_STATUS_UPDATED = 1
const val DATA_REFRESH_STATUS_LOADING = 2
const val DATA_REFRESH_STATUS_OLD = 3
const val DATA_REFRESH_STATUS_NO_CONNECTED= 4

val dataRefreshStatusStrings: List<Int> =
    arrayListOf(R.string.dataRefreshUpdate, R.string.dataRefreshUpdating, R.string.dataRefreshOld,R.string.dataRefreshNoConnected)

val dataRefreshStatusColor: List<Color> =
    arrayListOf(Color.Green, Color.Yellow, Color.Gray, Color.Red)
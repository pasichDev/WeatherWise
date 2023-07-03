package com.pasichdev.weatherwise.data.repository

import com.pasichdev.weatherwise.data.network.ApiService
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : AppRepository  {
}
package com.pasichdev.weatherwise.ui.screen.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasichdev.weatherwise.data.model.WeatherCurrentDay
import com.pasichdev.weatherwise.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var appRepository: AppRepository,
) : ViewModel() {


    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()


    init {
        fetchWeatherCurrentDay("London")
    }

    fun fetchWeatherCurrentDay(country: String) {
        viewModelScope.launch {
            try {
                _state.update { state ->
                    state.copy(
                        currentDay = appRepository.getWeatherCurrentDay(country = country)
                    )
                }
            } catch (e: Exception) {
                // Обробка помилок
            }
        }
    }
}
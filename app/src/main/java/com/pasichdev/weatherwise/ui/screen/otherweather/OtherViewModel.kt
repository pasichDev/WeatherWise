package com.pasichdev.weatherwise.ui.screen.otherweather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasichdev.weatherwise.data.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtherViewModel @Inject constructor(
    private var appRepository: AppRepository,
) : ViewModel() {


    private val _state = MutableStateFlow(OtherState())
    val state: StateFlow<OtherState> = _state.asStateFlow()


    init {
        fetchWeatherCurrentDay("Rivne")
    }

    private fun fetchWeatherCurrentDay(country: String) {
        viewModelScope.launch {
            try {
                _state.update { state ->
                    state.copy(
                        currentDay = appRepository.getWeatherOtherDays(country = country)
                    )
                }
            } catch (e: Exception) {
                // Обробка помилок
            }
        }
    }
}
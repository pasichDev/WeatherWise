package com.pasichdev.weatherwise.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pasichdev.weatherwise.data.DataStoreManager
import com.pasichdev.weatherwise.data.repository.AppRepository
import com.pasichdev.weatherwise.utils.DATA_REFRESH_STATUS_NO_CONNECTED
import com.pasichdev.weatherwise.utils.DATA_REFRESH_STATUS_UPDATED
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private var appRepository: AppRepository, private val dataStoreManager: DataStoreManager
) : ViewModel() {


    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()


    init {
        fetchLocationWeather()
        fetchWeatherLocalDatabase()
        fetchWeatherCurrentDay()
    }


    fun fetchLocationWeather() {
        viewModelScope.launch {
            dataStoreManager.userPreferencesFlow.collect {
                _state.update { state ->
                    state.copy(
                        locationWeather = it.locationWeather
                    )
                }
            }
        }
    }

    private fun fetchWeatherLocalDatabase() {
        viewModelScope.launch {
            appRepository.getWeather().collect { weather ->
                _state.update { state ->
                    state.copy(
                        currentDay = weather
                    )
                }

            }
        }
    }

    fun updateFetch() = fetchWeatherCurrentDay()
    fun updateLocationWeather(locationWeather: String) {
        viewModelScope.launch { dataStoreManager.saveLocationWeather(locationWeather) }
    }

    fun fetchResultLocationSearch(location: String) {
        viewModelScope.launch {
            try {
                _state.update { state ->
                    state.copy(
                        listCityWeather = appRepository.getResultSearchCity(location)
                    )
                }
            } catch (_: Exception) {

            }
        }
    }

    private fun fetchWeatherCurrentDay() {
        state.distinctUntilChangedBy { homeState ->
            homeState.locationWeather
        }.map {
            try {
                appRepository.updateWeatherLocal(appRepository.getWeatherCurrentDay(country = state.value.locationWeather))
                _state.update { state ->
                    state.copy(
                        dataRefreshStatus = DATA_REFRESH_STATUS_UPDATED
                    )
                }
            } catch (e: Exception) {
                _state.update { state ->
                    state.copy(
                        dataRefreshStatus = DATA_REFRESH_STATUS_NO_CONNECTED
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}
package com.pasichdev.weatherwise.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.pasichdev.weatherwise.data.model.UserPreferences
import com.pasichdev.weatherwise.utils.DEFAULT_LOCATION_WEATHER
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    companion object {
        private val Location_Weather_KEY = stringPreferencesKey("locationWeather")
    }

    val userPreferencesFlow: Flow<UserPreferences>
        get() = dataStore.data.map { preferences ->
            val username = preferences[Location_Weather_KEY] ?: DEFAULT_LOCATION_WEATHER
            UserPreferences(username)
        }

    suspend fun saveLocationWeather(username: String) {
        dataStore.edit { preferences ->
            preferences[Location_Weather_KEY] = username
        }
    }


}
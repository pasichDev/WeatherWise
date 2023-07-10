package com.pasichdev.weatherwise.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.pasichdev.weatherwise.data.model.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

val DEFAULT_LOCATION =
    Location("London", "City of London, Greater London", "United Kingdom", "51.52", "-0.11")

@Singleton
class DataStoreManager @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {


    companion object {
        private val Location_Name_KEY = stringPreferencesKey("locationName")
        private val Location_Region_KEY = stringPreferencesKey("locationRegion")
        private val Location_Country_KEY = stringPreferencesKey("locationCountry")
        private val Location_Lat_KEY = stringPreferencesKey("locationLat")
        private val Location_Lon_KEY = stringPreferencesKey("locationLon")
    }

    val userPreferencesFlow: Flow<Location>
        get() = dataStore.data.map { preferences ->
            val name = preferences[Location_Name_KEY] ?: DEFAULT_LOCATION.name
            val region = preferences[Location_Region_KEY] ?: DEFAULT_LOCATION.region
            val country = preferences[Location_Country_KEY] ?: DEFAULT_LOCATION.country
            val lat = preferences[Location_Lat_KEY] ?: DEFAULT_LOCATION.lat
            val lon = preferences[Location_Lon_KEY] ?: DEFAULT_LOCATION.lon
            Location(name, region, country, lat, lon)
        }

    suspend fun saveLocation(userPreferences: Location) {
        dataStore.edit { preferences ->
            preferences[Location_Name_KEY] = userPreferences.name
            preferences[Location_Region_KEY] = userPreferences.region
            preferences[Location_Country_KEY] = userPreferences.country
            preferences[Location_Lat_KEY] = userPreferences.lat
            preferences[Location_Lon_KEY] = userPreferences.lon
        }
    }


}
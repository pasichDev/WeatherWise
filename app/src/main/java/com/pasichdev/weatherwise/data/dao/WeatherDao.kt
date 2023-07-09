package com.pasichdev.weatherwise.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pasichdev.weatherwise.data.model.Weather
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateWeather(weather: Weather)


    @Query("SELECT * FROM weather where weatherId = 1")
    fun getWeather(): Flow<Weather>
}
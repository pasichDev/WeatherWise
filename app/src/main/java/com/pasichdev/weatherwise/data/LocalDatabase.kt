package com.pasichdev.weatherwise.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pasichdev.weatherwise.data.converter.WeatherConverter
import com.pasichdev.weatherwise.data.dao.WeatherDao
import com.pasichdev.weatherwise.data.model.CurrentWeather
import com.pasichdev.weatherwise.data.model.Day
import com.pasichdev.weatherwise.data.model.Forecast
import com.pasichdev.weatherwise.data.model.ForecastDay
import com.pasichdev.weatherwise.data.model.Hour
import com.pasichdev.weatherwise.data.model.Location
import com.pasichdev.weatherwise.data.model.Weather
import com.pasichdev.weatherwise.utils.VERSION_DB

@Database(
    entities = [Weather::class], version = VERSION_DB
)


@TypeConverters(WeatherConverter::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract val weatherDao: WeatherDao
}
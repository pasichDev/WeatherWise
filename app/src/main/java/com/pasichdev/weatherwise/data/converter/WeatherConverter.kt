package com.pasichdev.weatherwise.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pasichdev.weatherwise.data.model.ConditionWeather
import com.pasichdev.weatherwise.data.model.CurrentWeather
import com.pasichdev.weatherwise.data.model.Day
import com.pasichdev.weatherwise.data.model.Forecast
import com.pasichdev.weatherwise.data.model.ForecastDay
import com.pasichdev.weatherwise.data.model.Hour
import com.pasichdev.weatherwise.data.model.Location

class WeatherConverter {


    @TypeConverter
    fun fromLocation(value: String): Location {
        val type = object : TypeToken<Location>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toLocation(source: Location): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromCurrentWeather(value: String): CurrentWeather {
        val type = object : TypeToken<CurrentWeather>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toCurrentWeather(source: CurrentWeather): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromConditionWeather(value: String): ConditionWeather {
        val type = object : TypeToken<ConditionWeather>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toConditionWeather(source: ConditionWeather): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromForecast(value: String): Forecast {
        val type = object : TypeToken<Forecast>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toForecast(source: Forecast): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromForecastDays(value: String): List<ForecastDay> {
        val type = object : TypeToken<List<ForecastDay>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toForecastDays(source: List<ForecastDay>): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromForecastDay(value: String): ForecastDay {
        val type = object : TypeToken<ForecastDay>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toForecastDay(source: ForecastDay): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun fromDay(value: String): Day {
        val type = object : TypeToken<Day>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toDay(source: Day): String {
        return Gson().toJson(source)
    }


    @TypeConverter
    fun fromHour(value: String): List<Hour> {
        val type = object : TypeToken<List<Hour>>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toHour(source: List<Hour>): String {
        return Gson().toJson(source)
    }


}
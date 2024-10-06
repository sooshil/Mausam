package com.sukajee.mausam.data.repository

import android.util.Log
import com.sukajee.mausam.data.api.WeatherApi
import com.sukajee.mausam.data.models.WeatherData
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
): BaseRepository {

    override suspend fun getWeatherData(latitude: Double, longitude: Double): Response<WeatherData> {
        Log.d("SomeImportantTag", "getWeatherData: with latitude: $latitude and longitude: $longitude ")
        return weatherApi.getWeatherData(
            latitude = latitude,
            longitude = longitude,
            current = "temperature_2m",
            unit = "fahrenheit"
        )
    }
}
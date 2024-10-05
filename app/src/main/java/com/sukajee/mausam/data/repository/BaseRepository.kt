package com.sukajee.mausam.data.repository

import com.sukajee.mausam.data.models.WeatherData
import retrofit2.Response

interface BaseRepository {

    suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Response<WeatherData>
}
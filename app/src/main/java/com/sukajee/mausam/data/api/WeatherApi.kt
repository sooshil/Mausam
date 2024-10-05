package com.sukajee.mausam.data.api

import com.sukajee.mausam.data.models.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String,
        @Query("temperature_unit") unit: String
    ): Response<WeatherData>
}
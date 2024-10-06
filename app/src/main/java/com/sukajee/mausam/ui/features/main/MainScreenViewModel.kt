package com.sukajee.mausam.ui.features.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.sukajee.mausam.data.models.WeatherData
import com.sukajee.mausam.data.repository.BaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val repository: BaseRepository
): ViewModel() {

    private var _weatherData = MutableStateFlow(WeatherData())
    val weatherData = _weatherData.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherData(
                    latitude = 34.0522,
                    longitude = -118.2437
                )
                response.body()?.let { weatherData ->

                    _weatherData.value = weatherData
                } ?: run {
                    Log.d("SomeImportantTag", "Failed to fetch weather data")
                }
            } catch (e: Exception) {
                Log.d("SomeImportantTag", "Network error: ${e.message}")
            }
        }
    }
}
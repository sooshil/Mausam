package com.sukajee.mausam.ui.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sukajee.mausam.data.models.WeatherData
import com.sukajee.mausam.data.repository.BaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    repository: BaseRepository
): ViewModel() {

    private var _weatherData = MutableStateFlow(WeatherData())
    val weatherData = _weatherData.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getWeatherData(
                latitude = 39.962761,
                longitude = -82.996292
            ).body()?.let {
                _weatherData.value = it
            }
        }
    }

}
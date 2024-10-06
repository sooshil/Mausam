package com.sukajee.mausam.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class WeatherData(
    val latitude: Double? = null,
    val longitude: Double? = null,
    val current: Current? = null
)

@Keep
data class Current(
    val time: String? = null,
    val interval: Int? = null,
    @SerializedName("temperature_2m")
    val temperature: Double? = null
)

package com.sukajee.mausam.ui.features.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    innerPadding: PaddingValues,
    viewModel: MainScreenViewModel
) {
    val weatherData by viewModel.weatherData.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Weather for the latitude: ${weatherData.latitude} and longitude: ${weatherData.longitude} is " +
            "\ntemperature: ${weatherData.current?.temperature}"
        )
    }
}
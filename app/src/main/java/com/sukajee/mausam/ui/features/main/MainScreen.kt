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
import androidx.compose.ui.unit.sp

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
        Text(text = "Weather for \nlatitude: ${weatherData.latitude} and \nlongitude: ${weatherData.longitude} is " +
            "\ntemperature: ${weatherData.current?.temperature}",
            fontSize = 30.sp
        )
    }
}
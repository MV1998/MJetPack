package com.mohit.mjetpack.components_screens.Sliders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@Composable
fun MSliders(navController: NavController) {
    var value by remember {
        mutableFloatStateOf(0.5f)
    }

    var rangeSliderPosition by remember {
        mutableStateOf(0f..100f)
    }

    Scaffold(
        topBar = {
            TopBar(title = "Sliders Example") {
                navController.popBackStack()
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center) {
            Column {
                Slider(
                    colors = SliderDefaults.colors(
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = Color.Red,
                        activeTickColor = MaterialTheme.colorScheme.secondary,
                        thumbColor = MaterialTheme.colorScheme.secondary
                    ),
                    value = value, onValueChange = {
                    value = it
                })
                Text(text = value.toString(), color = MaterialTheme.colorScheme.secondary)
                
                Spacer(modifier = Modifier.height(100.dp))
                RangeSlider(
                    colors = SliderDefaults.colors(
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = Color.Red,
                        activeTickColor = MaterialTheme.colorScheme.secondary,
                        thumbColor = MaterialTheme.colorScheme.secondary
                    ),
                    value = rangeSliderPosition, onValueChange = {
                    rangeSliderPosition = it
                }, valueRange = 0f..100f,
                    onValueChangeFinished = {

                    })
                Text(text = rangeSliderPosition.toString(), color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}
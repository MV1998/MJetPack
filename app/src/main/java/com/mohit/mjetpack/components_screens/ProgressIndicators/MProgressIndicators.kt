package com.mohit.mjetpack.components_screens.ProgressIndicators

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MProgressIndicators(navController: NavController) {

    val loaders = listOf("Determinate", "Indeterminate")

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopBar(title = "Progress Indicators Example") {
                navController.popBackStack()
            }
        },
        bottomBar = {
            NavigationBar {
                loaders.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedItem,
                        onClick = {
                                  selectedItem = index
                        },
                        icon = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")},
                        label = {
                            Text(text = item)
                        })
                }
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center) {
            if (selectedItem == 0) {
              Column(modifier = Modifier.fillMaxSize(),
                  verticalArrangement = Arrangement.SpaceEvenly,
                  horizontalAlignment = Alignment.CenterHorizontally) {
                  CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
                  LinearProgressIndicator(color = MaterialTheme.colorScheme.secondary)
              }
            }else {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(color = MaterialTheme.colorScheme.secondary)
                    LinearProgressIndicator(color = MaterialTheme.colorScheme.secondary)
                }
            }
        }
    }
}
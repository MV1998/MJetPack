package com.mohit.mjetpack.components_screens.Switch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@Composable
fun MSwitch(navController: NavController) {
    var check by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopBar(title ="Switch Example") {
                navController.popBackStack()
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center) {
            Switch(
                colors = SwitchDefaults.colors(
                    checkedTrackColor = MaterialTheme.colorScheme.secondary,
                    checkedThumbColor = MaterialTheme.colorScheme.primary
                ),
                checked = check, onCheckedChange = {
                check = it
            })
        }
    }
}
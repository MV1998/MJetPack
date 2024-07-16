package com.mohit.mjetpack.components_screens.MButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar


@Composable
fun buttons(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "Buttons") {
                navController.popBackStack()
            }
        },
        floatingActionButton = {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {
                ExtendedFloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    onClick = {

                }) {
                    Row {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.primary)
                        Text(text = "Search", color = MaterialTheme.colorScheme.primary)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                FloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    onClick = {}) {
                    Text(text = "FAB", color = MaterialTheme.colorScheme.primary)
                }
            }

        }
    ) {
        Column(modifier = Modifier
            .padding(paddingValues = it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { /*TODO*/ }) {
                Text("Save", color = MaterialTheme.colorScheme.secondary)
            }
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Text Button", color = MaterialTheme.colorScheme.secondary)
            }
            Spacer(
                modifier = Modifier.height(10.dp))
            FilledTonalButton(
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = { /*TODO*/ }) {
                Text("Tonal", color = MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text("Outlined", color = MaterialTheme.colorScheme.secondary)
            }
            Spacer(modifier = Modifier.height(10.dp))
            ElevatedButton(
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = { /*TODO*/ }) {
                Text("Elevated", color = MaterialTheme.colorScheme.primary)
            }
            Spacer(modifier = Modifier.height(10.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        }
    }
}
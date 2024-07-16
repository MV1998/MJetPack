package com.mohit.mjetpack.components_screens

import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun TopBar(title : String, onClick : () -> Unit) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.secondary,
        title = {
            Text(text = title, color = MaterialTheme.colorScheme.primary)
        }, navigationIcon = {
            IconButton(onClick = {
                onClick()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow",
                    tint = MaterialTheme.colorScheme.primary)
            }
        })
}
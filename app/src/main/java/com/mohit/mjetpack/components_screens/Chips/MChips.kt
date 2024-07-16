package com.mohit.mjetpack.components_screens.Chips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MChips(navController: NavController) {
    var filtered by remember {
        mutableStateOf(false)
    }

    var input by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBar(title = "Chips") {
                navController.popBackStack()
            }
        },
    ){
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            AssistChip(
                onClick = { /*TODO*/ }, label = {
                Text("Assist Chip", color = MaterialTheme.colorScheme.secondary)
            }, leadingIcon = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings",
                    tint = MaterialTheme.colorScheme.secondary)
            })

            Spacer(modifier = Modifier.padding(10.dp))

            FilterChip(
                colors = ChipDefaults.filterChipColors(
                    backgroundColor = MaterialTheme.colorScheme.tertiary
                ),
                selected = filtered, onClick = {
                filtered = !filtered
            }, leadingIcon = {
                Icon(imageVector = if (
                    filtered
                ) Icons.Default.Check else Icons.Default.Delete, contentDescription = "check",
                    tint = MaterialTheme.colorScheme.primary)
            }) {
                Text(text = "Filtered Chip", color = MaterialTheme.colorScheme.primary)
            }

            Spacer(modifier = Modifier.padding(10.dp))

            InputChip(
                selected = input, onClick = {
                input = !input
            }, label = {
                Text("Input Chip", color = MaterialTheme.colorScheme.secondary)
            }, avatar = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Localized description",
                    Modifier.size(InputChipDefaults.AvatarSize,),
                    tint = MaterialTheme.colorScheme.secondary
                )
            })

            Spacer(modifier = Modifier.padding(10.dp))
            SuggestionChip(
                colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {}, label = {
                Text(text = "Suggestion Chip", color = MaterialTheme.colorScheme.primary)
            })

            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedAssistChip(
                colors = AssistChipDefaults.elevatedAssistChipColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                ),
                onClick = { /*TODO*/ }, label = { Text("Elevated Assist Chip",
                    color = MaterialTheme.colorScheme.primary) })
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedFilterChip(
                colors = FilterChipDefaults.elevatedFilterChipColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                selected = filtered, onClick = { filtered = !filtered }, label = { Text("Elevated Filter Chip",
                    color = MaterialTheme.colorScheme.primary) })
            Spacer(modifier = Modifier.padding(10.dp))
            ElevatedSuggestionChip(
                colors = SuggestionChipDefaults.suggestionChipColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {  }, label = { Text("Elevated Suggestion Chip", color = MaterialTheme.colorScheme.primary) })
        }

    }
}
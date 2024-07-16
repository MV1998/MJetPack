package com.mohit.mjetpack.components_screens.RadioButtons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@Composable
fun MRadioButtons(navController: NavController) {

    var gender = listOf("Male", "Female", "Other")

    var selectedGender by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopBar(title = "Radio Button Example") {
                navController.popBackStack()
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)) {
            LazyColumn(modifier = Modifier.padding(10.dp).selectableGroup()) {
                items(gender.size) {
                   Row(
                       modifier = Modifier
                           .height(56.dp)
                           .selectable(selected = it == selectedGender,
                               onClick = {
                                   selectedGender = it
                               }, role = Role.RadioButton
                           )
                   ) {
                       androidx.compose.material3.RadioButton(
                           colors = RadioButtonDefaults.colors(
                               selectedColor = MaterialTheme.colorScheme.secondary,
                               unselectedColor = MaterialTheme.colorScheme.secondary
                           ),
                           selected =
                       selectedGender == it, onClick = null)
                       Spacer(modifier = Modifier.width(10.dp))
                       Text(gender[it], color = MaterialTheme.colorScheme.secondary)
                   }
                }
            }
        }
    }
}

/// Services finish today.
package com.mohit.mjetpack.components_screens.DatePicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MDatePicker(navController: NavController) {
    val dataPickerState = rememberDatePickerState(initialSelectedDateMillis = 1578096000000)

    var openDialog by remember {
        mutableStateOf(false)
    }

    val snackState = remember {
        SnackbarHostState()
    }

    val snackScope = rememberCoroutineScope()

    Scaffold(
        containerColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopBar(title = "Date Picker") {
                navController.popBackStack()
            }
        },
    ){

        if (openDialog) {
            val datePickerState = rememberDatePickerState()
            val confirmEnabled = remember {
                derivedStateOf { datePickerState.selectedDateMillis != null }
            }
            DatePickerDialog(onDismissRequest = {
                                                openDialog = false
            }, confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                        snackScope.launch {
                            snackState.showSnackbar(
                                "Selected date timestamp: ${datePickerState.selectedDateMillis}"
                            )
                        }
                    },
                ) {
                    Text("OK", color = MaterialTheme.colorScheme.primary)
                }
            }) {
                DatePicker(state = datePickerState)
            }
        }

        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            DatePicker(
                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    todayDateBorderColor = MaterialTheme.colorScheme.secondary,
                    yearContentColor = MaterialTheme.colorScheme.primary,
                    subheadContentColor = MaterialTheme.colorScheme.secondary,
                    weekdayContentColor = MaterialTheme.colorScheme.secondary,
                    headlineContentColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.secondary,
                    todayContentColor = MaterialTheme.colorScheme.secondary,
                    dayContentColor = MaterialTheme.colorScheme.secondary,
                    selectedDayContainerColor = MaterialTheme.colorScheme.secondary,
                    selectedDayContentColor = MaterialTheme.colorScheme.primary,
                    selectedYearContainerColor = MaterialTheme.colorScheme.primary,
                    selectedYearContentColor = MaterialTheme.colorScheme.secondary,
                    currentYearContentColor = MaterialTheme.colorScheme.tertiary,
                    dayInSelectionRangeContentColor = MaterialTheme.colorScheme.secondary
                ),
                state = dataPickerState, title = {
                Text("Select Event Date",
                    fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(10.dp))
            })

            Spacer(modifier = Modifier.height(10.dp))
            
            Button(onClick = { 
                openDialog = true
            }) {
                Text(text = "Date Picker", color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}
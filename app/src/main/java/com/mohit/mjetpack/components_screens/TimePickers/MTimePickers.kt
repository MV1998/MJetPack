package com.mohit.mjetpack.components_screens.TimePickers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import java.text.SimpleDateFormat
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MTimePickers(navController: NavController) {

    var showTimePicker by remember {
        mutableStateOf(false)
    }

    val state = rememberTimePickerState()

    val formatter = remember {
        SimpleDateFormat("hh:mm a", Locale.getDefault())
    }

    val snackState = remember {
        SnackbarHostState()
    }

    val snackScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(title = "Time Pickers") {
                navController.popBackStack()
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {
                showTimePicker = true
            }) {
                Text(text = "Set Time", color = MaterialTheme.colorScheme.primary)
            }
        }
        if (showTimePicker) {
            Dialog(onDismissRequest = {
                showTimePicker = false
            }) {
                Card(colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )) {
                    TimePicker(state = state, modifier = Modifier.padding(10.dp))
                }
            }
//            TimePickerDialog(
//                onCancel = { showTimePicker = false },
//                onConfirm = {
//                    val cal = Calendar.getInstance()
//                    cal.set(Calendar.HOUR_OF_DAY, state.hour)
//                    cal.set(Calendar.MINUTE, state.minute)
//                    cal.isLenient = false
//                    snackScope.launch {
//                        snackState.showSnackbar("Entered time: ${formatter.format(cal.time)}")
//                    }
//                    showTimePicker = false
//                },
//            ) {
//            }
        }
    }

}
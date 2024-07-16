package com.mohit.mjetpack.components_screens.Dialogs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MDialogs(navController: NavController) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    var showCardDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopBar(title = "Dialogs") {
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
            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {
                    Log.d("TAG", "MDialogs: onDismissRequest")
                    showDialog = false
                }, buttons = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text("Ok")
                    }
                }, title = {
                    Text("Enable Audio Permission.")
                }, text = {
                    Text("Audio permission are required for this application to work properly.")
                })
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {
                showDialog = true
            }) {
                Text("Alert Dialog", color = MaterialTheme.colorScheme.primary)
            }

            if (showCardDialog) {
                Dialog(

                    onDismissRequest = {
                    showCardDialog = false
                }) {
                    ElevatedCard(
                        colors = CardDefaults.elevatedCardColors(
                            containerColor = Color.White
                        ),
                        onClick = {  },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(text = "This is minimal a dialog",
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentSize(Alignment.Center),
                            textAlign = TextAlign.Center,)
                    }
                }
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {
                showCardDialog = true
            }) {
                Text("Card Dialog", color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}
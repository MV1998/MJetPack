package com.mohit.mjetpack.components_screens.SnackBar

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import kotlinx.coroutines.launch

@Composable
fun MSnackBar(navController: NavController) {
    val scope = rememberCoroutineScope()
    val snackHost = remember {
        SnackbarHostState()
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackHost)
        },
        topBar = {
            TopBar(title = "SnackBar Example") {
                navController.popBackStack()
            }
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                containerColor = MaterialTheme.colorScheme.primary,
                onClick = {
                scope.launch {
                  val result =  snackHost.showSnackbar("Hi Developer",
                      actionLabel = "Done")
                    when(result) {
                        SnackbarResult.Dismissed -> {
                            Log.d("TAG", "MSnackBar: Dismissed")
                        }
                        SnackbarResult.ActionPerformed -> {
                            Log.d("TAG", "MSnackBar: ActionPerformed")
                        }
                    }
                }
            }) {
                Text(text = "Show Snack Bar", color = MaterialTheme.colorScheme.secondary)
            }
        }
    ) {

        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {

        }
    }
}
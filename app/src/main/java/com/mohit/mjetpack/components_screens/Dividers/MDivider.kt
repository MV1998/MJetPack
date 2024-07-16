package com.mohit.mjetpack.components_screens.Dividers

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MDivider(navController: NavController) {
    val snackState = remember {
        SnackbarHostState()
    }
    val snackScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(snackState)
        },
        topBar = {
            TopBar(title = "Dividers") {
                navController.popBackStack()
            }
        },
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn {
                items(1000) {
                    Column {
                        ListItem(
                            modifier = Modifier
                                .clickable {
                                    snackScope.launch {
                                        snackState.showSnackbar("List Item No. $it")
                                    }
                                }
                                .background(
                                    color = MaterialTheme
                                        .colorScheme.primary
                                )
                                .padding(10.dp)
                        ) {
                            Text("List Item No. $it",
                                modifier = Modifier.padding(10.dp), MaterialTheme.colorScheme.secondary)
                        }
                        Divider(thickness = 1.dp,
                            color = Color.Gray)
                    }
                }
            }
        }
    }
}
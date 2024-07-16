package com.mohit.mjetpack.components_screens.Menus

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import kotlinx.coroutines.launch

@Composable
fun MMenus(navController: NavController) {

    var expand by remember {
        mutableStateOf(false)
    }

    val listOfDocumentation = listOf("Getting Started", "Pro Features", "Question & Answer", "Theme Integration", "Menu Output Options",
        "Developers", "Troubleshooting")

    val scrollState = rememberScrollState()
    val stateScope = rememberCoroutineScope()

    // declare the permission in the manifest file
    // check that permission is granted or not
    // if granted nothing to do, otherwise ask for the permission
    // show rationale dialog,


    val snackState  = remember {
        SnackbarHostState()
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackState)
        },
        topBar = {
            TopBar(title = "Menus") {
                navController.popBackStack()
            }
        },
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopStart)) {
                Row(verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            expand = true
                        }
                        .padding(10.dp)
                        .border(BorderStroke(1.dp, color = MaterialTheme.colorScheme.secondary))
                        .padding(10.dp)) {
                    Text(text = "Documentation", color = MaterialTheme.colorScheme.secondary)
                    Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "close-arrow",
                        tint = MaterialTheme.colorScheme.secondary)
                }
                DropdownMenu(expanded = expand, onDismissRequest = {
                    expand = false
                }) {
                    repeat(listOfDocumentation.size) {
                        DropdownMenuItem(text = { 
                                                Text(text = listOfDocumentation.get(it))
                        }, onClick = {
                            expand = false
                            stateScope.launch {
                                snackState.showSnackbar(listOfDocumentation[it])
                            }
                        },
                            leadingIcon = { Icon(Icons.Outlined.Edit, contentDescription = null) })
                    }
                }
                LaunchedEffect(expand) {
                    if (expand) {
                        scrollState.scrollTo(scrollState.maxValue)
                    }
                }
            }
        }
    }
}
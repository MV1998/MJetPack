package com.mohit.mjetpack.components_screens.Lists

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import java.security.Permission

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MLists(navController: NavController) {

    val context = LocalContext.current

    val permissions = arrayOf(Manifest.permission.CAMERA)

    var state by remember {
        mutableStateOf(false)
    }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestMultiplePermissions()) { it ->
        it.forEach {permission ->
            if (!permission.value) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(context as Activity, permission.key)) {
                    state = true
                }
            }
        }
    }
    
    if (state) {
        AlertDialog(onDismissRequest = {

        }, confirmButton = {
               Button(onClick = { state = false
                     launcher.launch(permissions) }) {
                  Text("Grant")
               }
        },
            icon = {
                   Icon(imageVector = Icons.Default.Favorite, contentDescription = "Heart")
            },
            text = {
                Text(text = "You need to grant the camera permission to use this upload feature")
            })
    }

    LaunchedEffect(key1 = Unit) {
            if (ActivityCompat.checkSelfPermission(context.applicationContext,
                Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
                launcher.launch(permissions)
            }
    }

    Scaffold(
        topBar = {
            TopBar(title = "Lists") {
                navController.popBackStack()
            }
        },
    ){
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            LazyColumn {
                items(1000) {
                    Column {
                        androidx.compose.material3.ListItem(
                            colors = ListItemDefaults.colors(
                                containerColor = MaterialTheme.colorScheme.primary
                            ),
                            headlineContent = {
                            Text("Three line list item", color = MaterialTheme.colorScheme.secondary)
                        }, overlineContent = {
                            Text("Overline", color = MaterialTheme.colorScheme.secondary)
                        }, supportingContent = {
                            Text("Secondary Text", color = MaterialTheme.colorScheme.secondary)
                        }, leadingContent = {
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Favorite",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }, trailingContent = {
                            Text("meta", color = MaterialTheme.colorScheme.secondary)
                        })
                        Divider(thickness = 1.dp,
                            color = Color.Gray)
                    }
                }
            }
        }
    }
}


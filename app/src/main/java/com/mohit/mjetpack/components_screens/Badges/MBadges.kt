package com.mohit.mjetpack.components_screens.Badges

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Badge
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun badgesScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "Badge Example") {
                navController.popBackStack()
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = false, onClick = {},
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge{
                                    Text(text = "19", color = Color.White)
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                        }
                    })
                NavigationBarItem(selected = false, onClick = {},
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge{
                                    Text(text = "29", color = Color.White)
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                        }
                    })
                NavigationBarItem(selected = false, onClick = {},
                    icon = {
                        BadgedBox(
                            badge = {
                                Badge{
                                    Text(text = "9", color = Color.White)
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                        }
                    })
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()) {

        }
    }
}
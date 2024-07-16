package com.mohit.mjetpack.components_screens.NavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar


@Composable
fun MNavigationRail(navController: NavController) {

    val items = listOf("Songs", "Artists", "Playlists")
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    var selectedItemPage by remember {
        mutableStateOf(items[selectedItem])
    }

    Scaffold(
        topBar = {
            TopBar(title = "Navigation Rail Example") {
                navController.popBackStack()
            }
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.secondary) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            selectedItemPage = items[selectedItem]
                        }
                    )
                }
            }
        }
    ) {
        Row(modifier = Modifier.padding(it)) {
            NavigationRail(
                containerColor = MaterialTheme.colorScheme.secondary
            ) {
                items.forEachIndexed { index, item ->
                    NavigationRailItem(
                        colors = NavigationRailItemDefaults.colors(
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            indicatorColor = MaterialTheme.colorScheme.primary,

                        ),
                        label = {
                                Text(text = item)
                        },
                        selected =selectedItem == index , onClick = {
                        selectedItem = index
                        selectedItemPage = items[selectedItem]
                    }, icon = {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                    })
                }
            }

            Box(modifier = Modifier

                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary)
                ,contentAlignment = Alignment.Center) {
                Text(selectedItemPage, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }

}
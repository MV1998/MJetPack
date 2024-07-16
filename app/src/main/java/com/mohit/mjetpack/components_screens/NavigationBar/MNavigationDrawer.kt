package com.mohit.mjetpack.components_screens.NavigationBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar
import kotlinx.coroutines.launch

@Composable
fun MNavigationDrawerBar(navController: NavController) {

    val items = listOf("Songs", "Artists", "Playlists")

    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    var selectedItemPage by remember {
        mutableStateOf(items[selectedItem])
    }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
        ModalDrawerSheet(
            drawerContainerColor = MaterialTheme.colorScheme.primary
        ) {
            items.forEachIndexed { index, item ->
                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(

                    ),
                    modifier = Modifier.padding(5.dp),
                    label = {
                   Text(text = item)
                }, selected = selectedItem == index, onClick = {
                    selectedItem = index
                    selectedItemPage = items[index]
                    scope.launch {
                        drawerState.close()
                    }
                }, icon = {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite")
                })
            }
        }
    }) {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            topBar = {
                TopBar(title = "Navigation Drawer Bar") {
                    navController.popBackStack()
                }
            },
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.secondary
                ) {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
                            label = { Text(item) },
                            selected = selectedItem == index,
                            onClick = {
                                selectedItem = index
                                selectedItemPage = items[index]
                            }
                        )
                    }
                }
            }
        ) {
            Box(modifier = Modifier
                .padding(it)
                .fillMaxSize()
                ,contentAlignment = Alignment.Center) {
                Text(selectedItemPage, color = MaterialTheme.colorScheme.secondary)
            }
        }
    }
}
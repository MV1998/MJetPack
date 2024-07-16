package com.mohit.mjetpack.components_screens.NavigationBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@Composable
fun MNavigationBottomBar(navController: NavController) {
    val items = listOf("Songs", "Artists", "Playlists")
    var selectedItem by remember {
        mutableIntStateOf(0)
    }

    var selectedItemPage by remember {
        mutableStateOf(items[selectedItem])
    }

    Scaffold(
        topBar = {
            TopBar(title = "Navigation Bottom Bar Example") {
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
                            selectedItemPage = items[selectedItem]
                        }
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
            ,contentAlignment = Alignment.Center) {
            Text(selectedItemPage, color = MaterialTheme.colorScheme.secondary)
        }
    }
}
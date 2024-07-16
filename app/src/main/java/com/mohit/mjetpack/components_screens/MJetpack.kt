package com.mohit.mjetpack.components_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Badge
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.utilities.ComponentList


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MJetPack(navController: NavController, navigateTo : (String) -> Unit) {
    Scaffold(
        topBar = {
            TopBar(title = "MJetpack Example") {
                navController.popBackStack()
            }
        }
    ) {
        LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 150.dp),
            modifier = Modifier
                .padding(it)
                .background(color = MaterialTheme.colorScheme.primary)) {
            items(ComponentList.list) {
                ListItem(modifier = Modifier
                    .clickable {
                        navigateTo(it.path)
                    }
                    .padding(5.dp)
                    .background(color = MaterialTheme.colorScheme.secondary)
                    .padding(5.dp)) {
                    Text(text = it.title, color = MaterialTheme.colorScheme.primary)
                }
            }
        }
    }
}
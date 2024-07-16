package com.mohit.mjetpack.components_screens.MTopBar


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ButtonColors
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

enum class TopAppBars {
    NONE, SMALL, CENTERED, MEDIUM, LARGE
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun topBars(navController: NavController,
            modifier: Modifier = Modifier) {

    var topAppBars by remember {
        mutableStateOf(TopAppBars.NONE)
    }

    Scaffold (
        containerColor = MaterialTheme.colorScheme.secondary,
        topBar = {
            TopBar(title = "Top App Bar") {
                navController.popBackStack()
            }
        }
    ) {paddingValues ->
        Column(modifier = modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)) {
            FlowRow(modifier = modifier.padding(10.dp)) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                    topAppBars = TopAppBars.NONE
                }) {
                    Text(text = "Default", color = MaterialTheme.colorScheme.primary)
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                    onClick = {
                    topAppBars = TopAppBars.SMALL
                }) {
                    Text(text = "Small App Bar", color = MaterialTheme.colorScheme.primary)
                }
                Button( colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),onClick = {
                    topAppBars = TopAppBars.CENTERED
                }) {
                    Text(text = "Centered Title App Bar", color = MaterialTheme.colorScheme.primary)
                }
                Button( colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),onClick = {
                    topAppBars = TopAppBars.MEDIUM
                }) {
                    Text(text = "Medium App Bar", color = MaterialTheme.colorScheme.primary)
                }
                Button( colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),onClick = {
                    topAppBars = TopAppBars.LARGE
                }) {
                    Text(text = "Large", color = MaterialTheme.colorScheme.primary)
                }
            }
            when(topAppBars) {
                TopAppBars.SMALL -> smallAppBar(paddingValues)
                TopAppBars.CENTERED -> centeredAppBar(paddingValues)
                TopAppBars.MEDIUM -> mediumAppBar(paddingValues)
                TopAppBars.LARGE -> largeAppBar(paddingValues = paddingValues)
                else -> Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Default App Bar")
                }
            }
        }
    }
}

@Composable
fun smallAppBar(paddingValues: PaddingValues) {
    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colorScheme.secondary,
                title = {
                Text("Small Top App Bar", color = MaterialTheme.colorScheme.primary)
            })
        }
    ) {
        Text("Small ", modifier = Modifier.padding(paddingValues = it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun centeredAppBar(paddingValues: PaddingValues) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                Text(text = "Centered Top App Bar")
            }, scrollBehavior = scrollBehavior, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                }
            })
        }
    ){
        Text("Centered", modifier = Modifier.padding(it))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mediumAppBar(paddingValues: PaddingValues) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                                    Text(text = "Medium App Bar")
            }, scrollBehavior = scrollBehavior,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                })
        }
    ) { it ->
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(1000) {item ->
                Text(text = " - List item number $item", modifier = Modifier.padding(10.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun largeAppBar(paddingValues: PaddingValues) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier
            .padding(paddingValues)
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor =  MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                Text(text = "Large App Bar")
            }, scrollBehavior = scrollBehavior)
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(1000) {item ->
                Text(text = " - List item number $item", modifier = Modifier.padding(10.dp))
            }
        }
    }
}
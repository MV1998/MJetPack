package com.mohit.mjetpack.components_screens.ToolTips

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MToolTip(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(title = "Tooltip Example") {
                navController.popBackStack()
            }
        }
    ) {
        Box(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary)
        , contentAlignment = Alignment.Center) {

            Text(text = "Implementation in progress.",
                color = MaterialTheme.colorScheme.secondary)
//            RichTooltipBox(
//                positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
//                tooltip = { PlainTooltip { Text("Add to favorites") } },
//                state = rememberTooltipState()
//            ) {
//                IconButton(onClick = { /* Icon button's click event */ }) {
//                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Localized Description")
//                }
//            }
        }
    }
}
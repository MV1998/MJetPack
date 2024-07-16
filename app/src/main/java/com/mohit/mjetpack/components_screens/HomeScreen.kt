package com.mohit.mjetpack.components_screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohit.mjetpack.utilities.ComponentList
import com.mohit.mjetpack.utilities.Routes

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun homeScreen(navigateTo: (route : String) -> Unit) {
    Scaffold {paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                colors = CardDefaults.elevatedCardColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = {

                },
                modifier = Modifier.padding(10.dp)) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = "Hi there, Welcome!!!", fontSize = 24.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "I was very curious to build the UIs in the Jetpack compose, By the way I have created UI in the xml layout but never thought that in the android a second option would be possible one day to implement UI in declarative way like Flutter or SwiftUI.",
                        fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(10.dp))
                    /*
                    "You would have visited this https://m3.material.io/components components list, it contains all the material3 widgets for android, flutter and jetpack compose."
                     */
                    Text(text = buildAnnotatedString {
                                                     withStyle(style = SpanStyle()) {
                                                         append("You would have visited this ")
                                                     }
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("https://m3.material.io/")
                        }
                        withStyle(style = SpanStyle()) {
                            append(" components list, it contains all the material3 widgets for android, flutter and jetpack compose.")
                        }
                    },
                        fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "If you want to learn each and every component that best idea to implement in the project or make use of it somewhere. I thought I should create an app which contains all the widgets and their source code.",
                        fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Application is in the dark and light mode.", fontSize = 14.sp, color = MaterialTheme.colorScheme.primary)
                }
            }
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.secondary),
                onClick = {
                    navigateTo(Routes.MJETPACK.name)
                }) {
                Text(text = "MJetpack",  color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

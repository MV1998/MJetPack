package com.mohit.mjetpack.components_screens.TextFields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mohit.mjetpack.components_screens.TopBar

@Composable
fun MTextFields(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    val errorMessage = "Text input too long"
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    Scaffold(
        topBar = {
            TopBar(title = "Text Fields Example") {
                navController.popBackStack()
            }
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primary),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                label = {
                    Text(text = "Email")
                },
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                label = {
                    Text(text = "Email")
                },
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "example@gmail.com")
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                label = {
                    Text(text = "Email")
                },
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "example@gmail.com")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                label = {
                    Text(text = "Email")
                },
                value = text,
                onValueChange = {
                    text = it
                },
                singleLine = true,
                placeholder = {
                    Text(text = "example@gmail.com")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Face, contentDescription = "Face")
                },
                prefix = {
                    Text("www.")
                },
                suffix = {
                    Text(text = ".com")
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            TextField(
                value = text,
                onValueChange = {
                    text = it
                    validate(text)
                },
                singleLine = true,
                label = { Text(if (isError) "Username*" else "Username") },
                supportingText = {
                    Row {
                        Text(if (isError) errorMessage else "", Modifier.clearAndSetSemantics {})
                        Spacer(Modifier.weight(1f))
                        Text("Limit: ${text.length}/$charLimit")
                    }
                },
                isError = isError,
                keyboardActions = KeyboardActions { validate(text) },
                modifier =
                Modifier.semantics {
                    if (isError) error(errorMessage)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") },
                supportingText = {
                    Text("Supporting text that is long and perhaps goes onto another line.")
                },
            )

            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    focusedSupportingTextColor = MaterialTheme.colorScheme.secondary
                ),
                value = text, onValueChange = {
                text = it
            })
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
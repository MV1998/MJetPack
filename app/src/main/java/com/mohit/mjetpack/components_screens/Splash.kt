package com.mohit.mjetpack.componen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohit.mjetpack.R
import com.mohit.mjetpack.utilities.Routes
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Splash(navigateTo: (route : String) -> Unit) {

    val job = remember {
        MainScope().launch {
            delay(3000)
            navigateTo(Routes.HOME.name)
        }
    }

    DisposableEffect(key1 = Unit) {
        onDispose {
            job.cancel()
        }
    }

    Box( modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center) {
        ElevatedCard(
            modifier = Modifier.padding(10.dp),
            onClick = { }
            ,colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Icon", tint = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "MJetPack", fontSize = 24.sp,
                    color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "All Jetpack Components have been used in this application for practicing purpose.", fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}
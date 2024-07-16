package com.mohit.mjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mohit.mjetpack.navigation.Navigation
import com.mohit.mjetpack.ui.theme.MJetPackTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   enableEdgeToEdge()

        setContent {
            MJetPackTheme(dynamicColor = false) {
                App()
            }
        }
    }
}

@Composable
fun App() {
    Navigation()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MJetPackTheme {
        App()
    }
}
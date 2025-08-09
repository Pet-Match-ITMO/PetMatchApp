package com.kernelescape.compose.petmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kernelescape.compose.petmatch.ui.theme.PetMatchAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PetMatchAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Навигация на экран профиля
                    com.kernelescape.compose.petmatch.ui.ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PetMatchAppTheme {
        // Превью экрана профиля вместо Greeting
        com.kernelescape.compose.petmatch.ui.ProfileScreen()
    }
}
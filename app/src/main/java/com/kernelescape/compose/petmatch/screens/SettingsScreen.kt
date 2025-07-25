package com.kernelescape.compose.petmatch.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.data.FakeData
import com.kernelescape.compose.petmatch.ui.theme.PetMatchAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit = {}
) {
    val settingsData = FakeData.settingsData

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Navigate back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Notifications setting
            ListItem(
                headlineContent = { Text("Notifications") },
                trailingContent = {
                    Switch(
                        checked = settingsData.notifications,
                        onCheckedChange = { }
                    )
                }
            )

            // Dark mode setting
            ListItem(
                headlineContent = { Text("Dark Mode") },
                trailingContent = {
                    Switch(
                        checked = settingsData.darkMode,
                        onCheckedChange = { }
                    )
                }
            )

            // Language setting
            ListItem(
                headlineContent = { Text("Language") },
                trailingContent = {
                    Text(settingsData.language)
                }
            )

            // Privacy setting
            ListItem(
                headlineContent = { Text("Privacy") },
                trailingContent = {
                    Switch(
                        checked = settingsData.privacyEnabled,
                        onCheckedChange = { }
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    PetMatchAppTheme {
        SettingsScreen()
    }
}
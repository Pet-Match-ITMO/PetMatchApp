package com.kernelescape.compose.data

object FakeData {
    // Profile data
    val profileData = ProfileData(
        name = "John Doe",
        email = "john.doe@example.com",
        phoneNumber = "+1 234 567 8900",
        bio = "Pet lover and outdoor enthusiast"
    )

    // Settings data
    val settingsData = SettingsData(
        notifications = true,
        darkMode = false,
        language = "English",
        privacyEnabled = true
    )
}

data class ProfileData(
    val name: String,
    val email: String,
    val phoneNumber: String,
    val bio: String
)

data class SettingsData(
    val notifications: Boolean,
    val darkMode: Boolean,
    val language: String,
    val privacyEnabled: Boolean
)
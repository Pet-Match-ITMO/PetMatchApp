package com.kernelescape.compose.petmatch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.petmatch.placeholder

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Профиль",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .align(Alignment.Start)
        )
        
        // Profile picture placeholder
        Box(
            modifier = Modifier
                .size(120.dp)
                .placeholder(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Профиль",
                modifier = Modifier.size(60.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Иван Петров",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )
        
        Text(
            text = "ivan.petrov@email.com",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        
        ProfileSection(
            title = "Личная информация",
            content = {
                InfoItem("Город", "Москва")
                InfoItem("Возраст", "35 лет")
                InfoItem("Опыт с животными", "5 лет")
            }
        )
        
        ProfileSection(
            title = "Предпочтения",
            content = {
                InfoItem("Тип питомца", "Собаки и кошки")
                InfoItem("Размер питомца", "Средний и крупный")
                InfoItem("Возраст питомца", "Молодые и взрослые")
            }
        )
        
        ProfileSection(
            title = "Настройки",
            content = {
                SettingItem(
                    icon = Icons.Default.Notifications,
                    text = "Уведомления",
                    onClick = { /* TODO: Handle notifications */ }
                )
                
                SettingItem(
                    icon = Icons.Default.Settings,
                    text = "Язык",
                    onClick = { /* TODO: Handle language */ }
                )
                
                SettingItem(
                    icon = Icons.Default.Info,
                    text = "О приложении",
                    onClick = { /* TODO: Show about */ }
                )
                
                SettingItem(
                    icon = Icons.Default.ExitToApp,
                    text = "Выйти",
                    onClick = { /* TODO: Handle logout */ },
                    isDestructive = true
                )
            }
        )
    }
}

@Composable
fun ProfileSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            
            content()
        }
    }
}

@Composable
fun InfoItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun SettingItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isDestructive: Boolean = false
) {
    ListItem(
        headlineContent = {
            Text(
                text = text,
                color = if (isDestructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
            )
        },
        leadingContent = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (isDestructive) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        modifier = modifier.clickable(onClick = onClick)
    )
}
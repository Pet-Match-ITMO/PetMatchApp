package com.kernelescape.compose.petmatch

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.kernelescape.compose.petmatch.PetCard
import com.kernelescape.compose.petmatch.R

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Избранные питомцы",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        item {
            Text(
                text = "Здесь отображаются питомцы, которые вы добавили в избранное",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
        
        // Sample favorites
        items(2) { index ->
            val imageResource = when (index % 5) {
                0 -> R.drawable.cat_1
                1 -> R.drawable.dog_1
                2 -> R.drawable.cat_2
                3 -> R.drawable.dog_2
                else -> R.drawable.cat_3
            }
            
            PetCard(
                name = "Любимчик ${index + 1}",
                breed = if (index % 2 == 0) "Собака" else "Кошка",
                age = "${index + 2} года",
                description = "Очень дружелюбный питомец, который ждет встречи с вами",
                imageResource = imageResource,
                showFavoriteButton = true,
                onFavoriteClick = { /* TODO: Remove from favorites */ }
            )
        }
        
        item {
            if (true) { // In a real app, this would check if favorites list is empty
                EmptyFavoritesView()
            }
        }
    }
}

@Composable
fun EmptyFavoritesView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder for empty state icon
        Box(
            modifier = Modifier
                .size(120.dp)
                .placeholder()
                .padding(bottom = 16.dp)
        )
        
        Text(
            text = "У вас пока нет избранных питомцев",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = "Добавляйте питомцев в избранное, чтобы легко находить их позже",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(bottom = 24.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        
        Button(onClick = { /* TODO: Navigate to search */ }) {
            Text("Найти питомцев")
        }
    }
}

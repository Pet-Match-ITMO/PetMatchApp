package com.kernelescape.compose.petmatch

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.petmatch.PetCard
import com.kernelescape.compose.petmatch.R

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf("Все") }
    var selectedAge by remember { mutableStateOf("Все") }
    
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text(
                text = "Поиск питомцев",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        item {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Поиск по имени или породе") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Поиск"
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Search
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
        
        item {
            FilterSection(
                selectedType = selectedType,
                onTypeSelected = { selectedType = it },
                selectedAge = selectedAge,
                onAgeSelected = { selectedAge = it }
            )
        }
        
        item {
            Text(
                text = "Результаты поиска",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp)
            )
        }
        
        // Sample search results
        items(3) { index ->
            val imageResource = when (index % 5) {
                0 -> R.drawable.dog_3
                1 -> R.drawable.cat_4
                2 -> R.drawable.dog_4
                3 -> R.drawable.cat_5
                else -> R.drawable.dog_5
            }
            
            PetCard(
                name = "Питомец ${index + 1}",
                breed = if (index % 2 == 0) "Собака" else "Кошка",
                age = "${index + 1} года",
                description = "Дружелюбный и игривый питомец, ищет любящую семью",
                imageResource = imageResource,
                showFavoriteButton = true,
                onFavoriteClick = { /* TODO: Add to favorites */ }
            )
        }
    }
}

@Composable
fun FilterSection(
    selectedType: String,
    onTypeSelected: (String) -> Unit,
    selectedAge: String,
    onAgeSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Фильтры",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedType == "Все",
                onClick = { onTypeSelected("Все") },
                label = { Text("Все") }
            )
            
            FilterChip(
                selected = selectedType == "Собаки",
                onClick = { onTypeSelected("Собаки") },
                label = { Text("Собаки") }
            )
            
            FilterChip(
                selected = selectedType == "Кошки",
                onClick = { onTypeSelected("Кошки") },
                label = { Text("Кошки") }
            )
        }
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterChip(
                selected = selectedAge == "Все",
                onClick = { onAgeSelected("Все") },
                label = { Text("Любой возраст") }
            )
            
            FilterChip(
                selected = selectedAge == "Молодые",
                onClick = { onAgeSelected("Молодые") },
                label = { Text("Молодые") }
            )
            
            FilterChip(
                selected = selectedAge == "Взрослые",
                onClick = { onAgeSelected("Взрослые") },
                label = { Text("Взрослые") }
            )
        }
    }
}

@Composable
fun FilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    AssistChip(
        onClick = onClick,
        label = label,
        modifier = modifier,
        colors = if (selected) {
            AssistChipDefaults.assistChipColors(
                containerColor = MaterialTheme.colorScheme.primary,
                labelColor = MaterialTheme.colorScheme.onPrimary
            )
        } else {
            AssistChipDefaults.assistChipColors()
        }
    )
}
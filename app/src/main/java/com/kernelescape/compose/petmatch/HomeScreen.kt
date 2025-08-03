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
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.petmatch.PetCard
import com.kernelescape.compose.petmatch.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Добро пожаловать в PetMatch!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            Text(
                text = "Найдите своего идеального питомца из приютов поблизости",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Новые питомцы",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    
                    Text(
                        text = "Посмотрите последних добавленных питомцев в приюты вашего города",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    
                    Button(
                        onClick = { /* TODO: Navigate to search */ },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text("Посмотреть")
                    }
                }
            }
        }
        
        item {
            Text(
                text = "Популярные питомцы",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
            )
        }
        
        // Sample pet items
        items(5) { index ->
            val imageResource = when (index % 5) {
                0 -> R.drawable.cat_1
                1 -> R.drawable.dog_1
                2 -> R.drawable.cat_2
                3 -> R.drawable.dog_2
                else -> R.drawable.cat_3
            }
            
            PetCard(
                name = "Питомец ${index + 1}",
                breed = if (index % 2 == 0) "Собака" else "Кошка",
                age = "${index + 1} года",
                description = "Дружелюбный и игривый питомец, ищет любящую семью",
                imageResource = imageResource
            )
        }
    }
}
package com.kernelescape.compose.petmatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PetCard(
    name: String,
    breed: String,
    age: String,
    description: String,
    imageResource: Int? = null,
    modifier: Modifier = Modifier,
    showFavoriteButton: Boolean = false,
    onFavoriteClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Pet image
            if (imageResource != null) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = "Фото питомца",
                    modifier = Modifier.size(80.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .placeholder()
                )
            }
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                
                Text(
                    text = "$breed, $age",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp),
                    maxLines = 2
                )
                
                if (showFavoriteButton && onFavoriteClick != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = onFavoriteClick) {
                            Text("В избранное")
                        }
                    }
                }
            }
        }
    }
}

// Placeholder modifier for pet images
fun Modifier.placeholder(): Modifier = this.then(
    Modifier.drawBehind {
        drawRect(color = androidx.compose.ui.graphics.Color.LightGray)
    }
)
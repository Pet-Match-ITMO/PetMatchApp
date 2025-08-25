package com.kernelescape.compose.presentation.uiComponents.screens.registration.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.resources.R
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentOrange
import com.kernelescape.compose.resources.ui.theme.RegistrationAccentTeal
import com.kernelescape.compose.resources.ui.theme.RegistrationFileUploadAccent
import com.kernelescape.compose.resources.ui.theme.RegistrationFileUploadBackground
import com.kernelescape.compose.resources.ui.theme.RegistrationFileUploadBorder
import com.kernelescape.compose.resources.ui.theme.RegistrationSecondaryText
import com.kernelescape.compose.resources.ui.theme.RegistrationSwitchTrack
import com.kernelescape.compose.resources.ui.theme.RegistrationTextPrimary
import com.kernelescape.compose.resources.ui.theme.RegistrationTextSecondary
import com.kernelescape.compose.resources.ui.theme.RegistrationWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = RegistrationTextSecondary) },
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = RegistrationAccentTeal,
            unfocusedBorderColor = RegistrationAccentTeal
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    passwordVisible: Boolean,
    onPasswordVisibilityChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            // Filter out newline characters
            onValueChange(newValue.replace("\n", ""))
        },
        label = { Text(text = label, color = RegistrationTextSecondary) },
        modifier = modifier
            .fillMaxWidth()
            .onKeyEvent { keyEvent ->
                keyEvent.key == Key.Enter // Consume the event
            },
        shape = RoundedCornerShape(12.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { onPasswordVisibilityChange(!passwordVisible) }) {
                Icon(
                    painter = if (passwordVisible) {
                        painterResource(R.drawable.ic_open_eye)
                    } else {
                        painterResource(
                            R.drawable.ic_close_eye
                        )
                    },
                    tint = RegistrationAccentOrange,
                    contentDescription = "PasswordVisibility"
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = RegistrationAccentTeal,
            unfocusedBorderColor = RegistrationAccentTeal
        )
    )
}

@Composable
fun TagSection(
    title: String,
    tags: List<String>,
    selectedTag: String,
    onTagSelected: (String) -> Unit,
    accentColor: Color,
    primaryTextColor: Color,
    whiteColor: Color,
    chipShape: Shape = RoundedCornerShape(20.dp)
) {
    Column {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 15.sp,
                color = RegistrationSecondaryText
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            maxItemsInEachRow = 3,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            tags.forEach { tag ->
                TagChip(
                    text = tag,
                    isSelected = tag == selectedTag,
                    onClick = { onTagSelected(tag) },
                    accentColor = accentColor,
                    primaryTextColor = primaryTextColor,
                    whiteColor = whiteColor,
                    shape = chipShape
                )
            }
        }
    }
}

@Composable
fun FlowRow(
    modifier: Modifier = Modifier,
    maxItemsInEachRow: Int = Int.MAX_VALUE,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
    verticalArrangement: Arrangement.Vertical = Arrangement.Top,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val rows = mutableListOf<List<androidx.compose.ui.layout.Placeable>>()
        val rowConstraints = constraints.copy(minWidth = 0)

        var currentRow = mutableListOf<androidx.compose.ui.layout.Placeable>()
        var currentRowWidth = 0
        var currentRowItemCount = 0

        measurables.forEach { measurable ->
            val placeable = measurable.measure(rowConstraints)

            if (currentRowWidth + placeable.width > constraints.maxWidth || currentRowItemCount >= maxItemsInEachRow) {
                rows.add(currentRow)
                currentRow = mutableListOf()
                currentRowWidth = 0
                currentRowItemCount = 0
            }

            currentRow.add(placeable)
            currentRowWidth += placeable.width
            if (currentRow.size > 1) {
                currentRowWidth += horizontalArrangement.spacing.roundToPx()
            }
            currentRowItemCount++
        }

        if (currentRow.isNotEmpty()) {
            rows.add(currentRow)
        }

        val height = rows.sumOf { row -> row.maxOfOrNull { it.height } ?: 0 } +
            if (rows.size > 1) (rows.size - 1) * verticalArrangement.spacing.roundToPx() else 0

        layout(constraints.maxWidth, height) {
            var y = 0

            rows.forEach { row ->
                val rowHeight = row.maxOfOrNull { it.height } ?: 0
                var x = 0

                row.forEach { placeable ->
                    placeable.place(x, y)
                    x += placeable.width + horizontalArrangement.spacing.roundToPx()
                }

                y += rowHeight + verticalArrangement.spacing.roundToPx()
            }
        }
    }
}

@Composable
fun TagChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    accentColor: Color,
    primaryTextColor: Color,
    whiteColor: Color,
    shape: Shape
) {
    val backgroundColor = if (isSelected) accentColor else whiteColor
    val textColor = if (isSelected) whiteColor else primaryTextColor

    Box(
        modifier = Modifier
            .clip(shape)
            .background(color = backgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                color = textColor
            )
        )
    }
}

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    trackColor: Color = RegistrationSwitchTrack,
    thumbColor: Color = RegistrationWhite
) {
    val thumbRadius = 10.dp // радиус кружка
    val trackWidth = 42.dp // ширина переключателя
    val trackHeight = 24.dp // высота переключателя

    // Анимация позиции кружка
    val thumbOffset by animateDpAsState(
        targetValue = if (checked) trackWidth - thumbRadius * 2 - 2.dp else 2.dp,
        label = "thumbOffset"
    )

    Box(
        modifier = modifier
            .width(trackWidth)
            .height(trackHeight)
            .clip(CircleShape)
            .background(color = trackColor) // фон без рамки
            .clickable { onCheckedChange(!checked) },
        contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .offset(x = thumbOffset)
                .size(thumbRadius * 2) // диаметр = 2 * радиус
                .background(color = thumbColor, shape = CircleShape)
        )
    }
}

@Composable
fun UploadFileCard(
    onClick: () -> Unit,
    hint: String
) {
    // Extract color resources to composable context
    val borderColor = RegistrationFileUploadBorder
    val backgroundColor = RegistrationFileUploadBackground
    val accentColor = RegistrationFileUploadAccent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .drawBehind {
                val stroke = Stroke(
                    width = 2.dp.toPx(),
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(18f, 10f))
                )
                drawRoundRect(
                    color = borderColor,
                    style = stroke,
                    cornerRadius = CornerRadius(8.dp.toPx())
                )
            }
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Иконка документа в кружочке
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(color = backgroundColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_documents),
                    contentDescription = null,
                    tint = borderColor
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Текстовая часть
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(R.string.registration_worker_upload_file_title),
                    color = RegistrationTextPrimary,
                    fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = hint,
                    color = RegistrationTextSecondary,
                    fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            // Плюсик в кружочке (обводка)
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .border(width = 1.5.dp, color = accentColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = accentColor,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

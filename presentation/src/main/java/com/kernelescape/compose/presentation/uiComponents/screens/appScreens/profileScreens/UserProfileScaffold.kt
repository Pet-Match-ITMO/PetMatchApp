package com.kernelescape.compose.presentation.uiComponents.screens.appScreens.profileScreens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kernelescape.compose.presentation.uiComponents.common.PrimaryButton
import com.kernelescape.compose.presentation.uiComponents.common.playfairBlack
import com.kernelescape.compose.presentation.uiComponents.common.sfProTextMedium
import com.kernelescape.compose.presentation.uiComponents.common.sfProTextRegular
import com.kernelescape.compose.resources.R

@Composable
fun UserProfileScaffold(
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            Column(Modifier.padding(bottom = 10.dp)) {
                TopProfileBar()
                CurrentScreenRow()
                Text(
                    text = "Питомцы приюта",
                    fontSize = 22.sp,
                    lineHeight = 28.sp,
                    letterSpacing = 0.sp,
                    fontFamily = playfairBlack,
                    color = Color(0xFF2A3138),
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        },
        bottomBar = { BottomAppBar() },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 20.dp),
        contentWindowInsets = WindowInsets.systemBars
    ) { paddingValues ->

        // Контент, который ты передаешь в Scaffold
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // учитываем topBar и системные отступы
            contentAlignment = Alignment.TopCenter
        ) {
            content()
        }
    }
}

@Composable
fun TopProfileBar() {
    val playfairDisplayBlack =
        FontFamily(Font(R.font.playfair_display_black, weight = FontWeight.Black))
    val sfProTextRegular = FontFamily(Font(R.font.sf_pro_text_regular))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        IconButton(
            onClick = { /* TODO: обработка клика */ },
            modifier = Modifier
                .background(Color(0xFFD9E9EB), shape = CircleShape)
                .weight(0.2f)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_profile_photo),
                contentDescription = "Profile photo",
                tint = Color(0xFF35A2AB),
                modifier = Modifier
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp)
        ) {
            Text(
                text = "Вероника",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = playfairDisplayBlack,
                fontSize = 27.sp,
                color = Color(0xFF2D353D)
            )
            Text(
                text = "Администратор приюта",
                fontFamily = sfProTextRegular,
                fontSize = 15.sp,
                color = Color(0xFF2D353D)
            )
        }

        IconButton(
            onClick = { /* TODO: обработка клика */ }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_edit_profile),
                contentDescription = "Profile photo",
                tint = Color(0xFFDB643E)
            )
        }
    }
}

@Composable
fun CurrentScreenRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFD9E9EB), shape = RoundedCornerShape(15.dp))
    ) {
        CurrentScreenItem(screenName = "Питомцы", isActive = true, modifier = Modifier.weight(1f))
        CurrentScreenItem(screenName = "Сборы", isActive = false, modifier = Modifier.weight(1f))
        CurrentScreenItem(screenName = "О приюте", isActive = false, modifier = Modifier.weight(1f))
    }
}

@Composable
fun CurrentScreenItem(screenName: String, isActive: Boolean, modifier: Modifier = Modifier) {
    TextButton(
        onClick = {},
        modifier = modifier
            .padding(2.dp)
            .background(
                if (isActive) Color.White else Color.Transparent,
                shape = RoundedCornerShape(15.dp)
            )

    ) {
        Text(
            text = screenName,
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = 0.sp,
            fontFamily = sfProTextRegular,
            color = Color(0xFF2A3138)
        )
    }
}

@Composable
fun BottomAppBar() {
    Column(modifier = Modifier.fillMaxWidth()) {
        PrimaryButton(
            text = "Добавить питомца",
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            BottomAppBarItem(
                icon = R.drawable.ic_paw,
                label = "Питомцы",
                isActive = false,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            BottomAppBarItem(
                icon = R.drawable.ic_heart,
                label = "Помощь",
                isActive = false,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            BottomAppBarItem(
                icon = R.drawable.ic_book,
                label = "Советы",
                isActive = false,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            BottomAppBarItem(
                icon = R.drawable.ic_person,
                label = "Профиль",
                isActive = true,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun BottomAppBarItem(
    @DrawableRes icon: Int,
    label: String,
    isActive: Boolean,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick, modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                modifier = Modifier.size(24.dp),
                tint = if (!isActive) Color(0xFF35A2AB) else Color(0xFFDB643E)
            )
            Text(
                text = label,
                fontSize = 10.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.sp,
                fontFamily = if (!isActive) sfProTextRegular else sfProTextMedium,
                color = if (!isActive) Color(0xFF6D7278) else Color(0xFF2A3138)
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun Preview() {
    UserProfileScaffold({ Box(modifier = Modifier.fillMaxSize()) })
}

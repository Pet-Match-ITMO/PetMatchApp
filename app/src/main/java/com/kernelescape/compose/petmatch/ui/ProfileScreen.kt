package com.kernelescape.compose.petmatch.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kernelescape.compose.petmatch.R

/**
 * Adaptive implementation of the "Profile view (Unfollow)" screen from Figma.
 * Requirements:
 * - Repeat Figma (390x844) and scale adaptively for other widths.
 * - Box cover with overlay controls, avatar overlapping with negative offset.
 * - Sticky info block layout with equal paddings 16dp.
 * - Material3 components.
 */
@Composable
fun ProfileScreen() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { innerPadding ->
        val screenWidth = LocalConfiguration.current.screenWidthDp
        // Scale around Figma base width 390dp, clamp to sensible range
        val scale = (screenWidth / 390f).coerceIn(0.85f, 1.25f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Cover with top controls overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((220 * scale).dp)
            ) {
                // Use reference image (flattened static mock) as visual guide until full asset slicing is ready
                Image(
                    painter = painterResource(id = R.drawable.cover_frame_62),
                    contentDescription = "Cover",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                // Overlay controls (kept for future interactivity)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = (16 * scale).dp, vertical = (12 * scale).dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_export),
                        contentDescription = "Export",
                        tint = Color.White
                    )
                }
            }

            // Return to simple overlap approach (no white rounded card), fix overlap only
            // Place name on white background: draw a white strip overlapping cover, then content on top
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-40 * scale).dp)
            ) {
                // White strip behind the name/title
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((56 * scale).dp)
                        .background(Color.White)
                        .align(Alignment.TopStart)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = (16 * scale).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.avatar_image_4),
                        contentDescription = "Avatar",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size((88 * scale).dp)
                            .clip(CircleShape)
                    )
                    Column(
                        modifier = Modifier.padding(start = (16 * scale).dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "First Second Name", fontWeight = FontWeight.SemiBold)
                            Spacer(Modifier.size((6 * scale).dp))
                            Icon(
                                painter = painterResource(R.drawable.ic_verify),
                                contentDescription = "Verified",
                                tint = Color(0xFF6C4DFE)
                            )
                        }
                        Text(
                            text = "Founding Rector of American University Stockholm",
                            color = Color(0xFF6C4DFE)
                        )
                    }
                }
            }

            Spacer(Modifier.height((8 * scale).dp))

            // Actions row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (16 * scale).dp),
                horizontalArrangement = Arrangement.spacedBy((12 * scale).dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionChip(icon = R.drawable.ic_tab_scan, text = "Schedule a call", scale = scale)
                ActionChip(icon = R.drawable.ic_calendar, text = "View events", scale = scale)
                Spacer(Modifier.weight(1f))
                UnfollowButton(scale)
            }

            // Stats
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (16 * scale).dp, vertical = (8 * scale).dp),
                horizontalArrangement = Arrangement.spacedBy((24 * scale).dp)
            ) {
                Text(text = "130 Following")
                Text(text = "23.5K Followers")
            }

            // Location + Joined date (align baselines to avoid vertical drift)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (16 * scale).dp, vertical = (4 * scale).dp),
                horizontalArrangement = Arrangement.spacedBy((24 * scale).dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location",
                        tint = Color(0xFF8F8A9B)
                    )
                    Spacer(Modifier.width((6 * scale).dp))
                    Text(text = "Sweden, Stockholm", color = Color(0xFF8F8A9B))
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = "Joined Date",
                        tint = Color(0xFF8F8A9B)
                    )
                    Spacer(Modifier.width((6 * scale).dp))
                    Text(text = "Joined November 2010", color = Color(0xFF8F8A9B))
                }
            }

            HorizontalDivider(color = Color(0xFFE9E6F3), thickness = 1.dp)
 
            // Top tabs
            PhotoTabsSection()
 
            // Horizontal photo preview
            PhotosPreviewRow()
 
            // Remove extra divider + secondary section to avoid duplication per Figma
        }
    }
}

@Composable
private fun ActionChip(icon: Int, text: String, scale: Float, heightDp: androidx.compose.ui.unit.Dp = (44 * scale).dp) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF6C4DFE).copy(alpha = 0.12f),
            contentColor = Color(0xFF6C4DFE)
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape((22 * scale).dp),
        modifier = Modifier.height(heightDp)
    ) {
        Icon(painterResource(icon), contentDescription = null, tint = Color(0xFF6C4DFE))
        Spacer(Modifier.size((8 * scale).dp))
        Text(text)
    }
}

@Composable
private fun UnfollowButton(scale: Float, heightDp: androidx.compose.ui.unit.Dp = (44 * scale).dp) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF3B30),
            contentColor = Color.White
        ),
        shape = androidx.compose.foundation.shape.RoundedCornerShape((22 * scale).dp),
        modifier = Modifier.height(heightDp)
    ) {
        Text("Unfollow")
    }
}

@Composable
private fun PhotoTabsSection() {
    var selected by remember { mutableStateOf(0) }
    val titles = listOf("Photo", "Videos", "Favorite", "Archive", "Files")
    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selected,
            containerColor = Color.Transparent,
            contentColor = Color(0xFF6C4DFE),
            indicator = { tabPositions ->
                // indicator 2dp height and width by tab text
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[selected]),
                    color = Color(0xFF6C4DFE),
                    height = 2.dp
                )
            },
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selected == index,
                    onClick = { selected = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selected == index) Color(0xFF6C4DFE) else Color(0xFF8F8A9B),
                            fontWeight = if (selected == index) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                )
            }
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Composable
private fun PhotosPreviewRow() {
    val scroll = rememberScrollState()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(scroll)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // PNGs copied to drawable as photos_preview_1..5
        PreviewImageBox(R.drawable.photos_preview_1)
        PreviewImageBox(R.drawable.photos_preview_2)
        PreviewImageBox(R.drawable.photos_preview_3)
        PreviewImageBox(R.drawable.photos_preview_4)
        PreviewImageBox(R.drawable.photos_preview_5)
    }
}

@Composable
private fun PreviewImageBox(resId: Int) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = "Preview",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(96.dp)
    )
}

@Composable
private fun SecondaryTabsSection() {
    var selected by remember { mutableStateOf(0) }
    val titles = listOf("Short news", "Posts", "Events")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = selected,
            containerColor = Color.Transparent,
            contentColor = Color(0xFF6C4DFE),
            indicator = { positions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier = Modifier.tabIndicatorOffset(positions[selected]),
                    color = Color(0xFF6C4DFE),
                    height = 2.dp
                )
            },
            divider = {}
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    selected = selected == index,
                    onClick = { selected = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selected == index) Color(0xFF6C4DFE) else Color(0xFF8F8A9B),
                            fontWeight = if (selected == index) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                )
            }
        }
        // Section placeholder content block
        when (selected) {
            0 -> SectionCard(title = "Short news", subtitle = "Latest updates from profile")
            1 -> SectionCard(title = "Posts", subtitle = "No posts yet")
            2 -> SectionCard(title = "Events", subtitle = "No upcoming events")
        }
    }
}

@Composable
private fun SectionCard(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F6FB))
            .padding(horizontal = 16.dp, vertical = 20.dp)
    ) {
        Text(text = title, color = Color(0xFF6C4DFE), fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(6.dp))
        Text(text = subtitle, color = Color(0xFF8F8A9B))
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.ic_tab_home), contentDescription = "Home") },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.ic_tab_search), contentDescription = "Search") },
            label = { Text("Search") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.ic_tab_message), contentDescription = "Messages") },
            label = { Text("Messages") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.ic_tab_scan), contentDescription = "Scan") },
            label = { Text("Scan") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(painterResource(id = R.drawable.ic_tab_menu), contentDescription = "Menu") },
            label = { Text("Menu") }
        )
    }
}

@Preview(showBackground = true, widthDp = 390, heightDp = 844)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
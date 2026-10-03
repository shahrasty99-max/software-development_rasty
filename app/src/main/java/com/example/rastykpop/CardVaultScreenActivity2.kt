package com.example.rastykpop
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val PrimaryGreen = Color(0xFF10C98F)
val ScreenBgColor = Color(0xFFF4F6F8)

data class CategoryItem(
    val id: Int,
    val title: String,
    val itemCount: Int,
    val iconEmoji: String
)

data class VaultCardItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val extraInfo: String = "",
    val cardType: String = "",
    val expiry: String = "",
    val gradientColors: List<Color>
)

@Composable
fun CardVaultApp() {
    var currentScreen by remember { mutableStateOf("dashboard") }

    Box(modifier = Modifier.fillMaxSize()) {
        if (currentScreen == "dashboard") {
            CardDashboardScreen(onCategoryClick = { currentScreen = "list" })
        } else {
            CardListScreen(onBackClick = { currentScreen = "dashboard" })
        }
    }
}

@Composable
fun CardDashboardScreen(
    onCategoryClick: (CategoryItem) -> Unit = {}
) {
    val categories = listOf(
        CategoryItem(1, "Text", 11, "📖"),
        CategoryItem(2, "Address", 3, "🏠"),
        CategoryItem(3, "Character", 15, "🦸‍♂️"),
        CategoryItem(4, "Bank card", 5, "💳"),
        CategoryItem(5, "Password", 21, "🔑"),
        CategoryItem(6, "Logistics", 10, "📦")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryGreen)
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Card",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Simple and easy to use app",
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "👤", fontSize = 22.sp)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(PrimaryGreen)
                .padding(horizontal = 16.dp)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    items(categories) { item ->
                        CategoryCard(item = item, onClick = { onCategoryClick(item) })
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))
                SettingsCard()
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun CategoryCard(item: CategoryItem, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(PrimaryGreen.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = item.iconEmoji, fontSize = 24.sp)
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color(0xFF222222)
            )

            Text(
                text = "${item.itemCount} items content",
                fontSize = 11.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun SettingsCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable { }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFEEEEEE)),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "⚙️", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color(0xFF222222)
                )
                Text(
                    text = "Fingerprint code and so on",
                    fontSize = 11.sp,
                    color = Color.Gray
                )
            }
        }
    }
}
@Composable
fun CardListScreen(
    onBackClick: () -> Unit = {}
) {
    val cards = listOf(
        VaultCardItem(
            id = 1,
            title = "Dribbble",
            subtitle = "Paidax",
            extraInfo = "••••••••••",
            gradientColors = listOf(Color(0xFFFFB733), Color(0xFFFF8800))
        ),
        VaultCardItem(
            id = 2,
            title = "HJM",
            subtitle = "173****8838",
            gradientColors = listOf(Color(0xFF3B82F6), Color(0xFF1D4ED8))
        ),
        VaultCardItem(
            id = 3,
            title = "Tom",
            subtitle = "Room 601, Building 8, Zhongnan Century City, No.8, Taoyuan Road...",
            extraInfo = "130****9920",
            gradientColors = listOf(Color(0xFF34D399), Color(0xFF059669))
        ),
        VaultCardItem(
            id = 4,
            title = "1882 **** **** 8695",
            subtitle = "ICBC",
            cardType = "Debit Card",
            expiry = "12/19",
            gradientColors = listOf(Color(0xFF8B5CF6), Color(0xFF6D28D9))
        ),
        VaultCardItem(
            id = 5,
            title = "Young",
            subtitle = "This is the story of me and them, very...",
            gradientColors = listOf(Color(0xFFF87171), Color(0xFFDC2626))
        ),
        VaultCardItem(
            id = 6,
            title = "Jinjun street, golden chrysanthemum Road, Haizhu District",
            subtitle = "",
            gradientColors = listOf(Color(0xFF60A5FA), Color(0xFF2563EB))
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBgColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PrimaryGreen)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Text(
                        text = "Card",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "👤", fontSize = 18.sp)
                }
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                items(cards) { card ->
                    GradientVaultCard(card)
                }
            }
        }
        FloatingActionButton(
            onClick = { /* Add Card */ },
            containerColor = PrimaryGreen,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .size(56.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add Card",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun GradientVaultCard(card: VaultCardItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(colors = card.gradientColors)
                )
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = card.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    if (card.subtitle.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = card.subtitle,
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.85f),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (card.cardType.isNotEmpty()) {
                        Text(
                            text = card.cardType,
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    } else if (card.extraInfo.isNotEmpty()) {
                        Text(
                            text = card.extraInfo,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }

                    if (card.expiry.isNotEmpty()) {
                        Text(
                            text = card.expiry,
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.8f)
                        )
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, name = "1. Dashboard Screen")
@Composable
fun CardDashboardScreenPreview() {
    CardDashboardScreen()
}

@Preview(showBackground = true, name = "2. Card List Screen")
@Composable
fun CardListScreenPreview() {
    CardListScreen()
}

package com.example.rastykpop
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
data class ArtistItem(val id: Int, val name: String, val emojiPlaceholder: String)
data class WrappedItem(val id: Int, val title: String, val bgColor: Color, val accentColor: Color)
data class PlaylistCard(val id: Int, val coverTitle: String, val description: String, val bgGradientStart: Color, val bgGradientEnd: Color)

@Composable
fun SpotifyHomeScreen(
    onNotificationClick: () -> Unit = {},
    onHistoryClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    val spotifyDarkBg = Color(0xFF121212)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(spotifyDarkBg)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 32.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TopHeaderSection(
            onNotificationClick = onNotificationClick,
            onHistoryClick = onHistoryClick,
            onSettingsClick = onSettingsClick
        )

        Spacer(modifier = Modifier.height(16.dp))
        RecentlyPlayedSection()

        Spacer(modifier = Modifier.height(28.dp))
        SpotifyWrappedHeader()

        Spacer(modifier = Modifier.height(16.dp))
        WrappedCardsSection()

        Spacer(modifier = Modifier.height(28.dp))
        EditorsPicksSection()
    }
}

@Composable
fun TopHeaderSection(
    onNotificationClick: () -> Unit,
    onHistoryClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Recently played",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Outlined.Notifications,
                contentDescription = "Notifications",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onNotificationClick() }
            )
            Icon(
                imageVector = Icons.Outlined.History,
                contentDescription = "History",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onHistoryClick() }
            )
            Icon(
                imageVector = Icons.Outlined.Settings,
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onSettingsClick() }
            )
        }
    }
}

@Composable
fun RecentlyPlayedSection() {
    val artists = listOf(
        ArtistItem(1, "Lana Del Rey", "👩🏼‍🌾"),
        ArtistItem(2, "Marvin Gaye", "🎷"),
        ArtistItem(3, "Taylor Swift", "🎤"),
        ArtistItem(4, "The Weeknd", "📻")
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(artists) { artist ->
            ArtistCircleCard(artist)
        }
    }
}

@Composable
fun ArtistCircleCard(artist: ArtistItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(110.dp)
    ) {
        Box(
            modifier = Modifier
                .size(108.dp)
                .clip(CircleShape)
                .background(Color(0xFF282828)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = artist.emojiPlaceholder, fontSize = 48.sp)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = artist.name,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
    }
}
@Composable
fun SpotifyWrappedHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFFC3F53C)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "2021",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = "#SPOTIFYWRAPPED",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFA7A7A7),
                letterSpacing = 1.sp
            )
            Text(
                text = "Your 2021 in review",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
@Composable
fun WrappedCardsSection() {
    val wrappedCards = listOf(
        WrappedItem(
            id = 1,
            title = "Your Top Songs 2021",
            bgColor = Color(0xFFD0F040),
            accentColor = Color(0xFF4700D3)
        ),
        WrappedItem(
            id = 2,
            title = "Your Artists Revealed",
            bgColor = Color(0xFFB5B2EF),
            accentColor = Color(0xFF2800D7)
        )
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(wrappedCards) { item ->
            WrappedSquareCard(item)
        }
    }
}

@Composable
fun WrappedSquareCard(item: WrappedItem) {
    Column(modifier = Modifier.width(155.dp)) {
        Box(
            modifier = Modifier
                .size(155.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(item.bgColor)
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(item.accentColor)
                    .align(Alignment.TopStart)
            )

            Column(modifier = Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = item.title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = item.accentColor,
                    lineHeight = 22.sp
                )
                Text(
                    text = "2021",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Black,
                    color = item.accentColor
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = item.title,
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun EditorsPicksSection() {
    val playlists = listOf(
        PlaylistCard(
            id = 1,
            coverTitle = "TOP 50",
            description = "Ed Sheeran, Big Sean, Juice WRLD, Post Malone",
            bgGradientStart = Color(0xFF3E5151),
            bgGradientEnd = Color(0xFFDECBA4)
        ),
        PlaylistCard(
            id = 2,
            coverTitle = "FRONT LEFT",
            description = "Mitski, Tame Impala, Glass Animals, Charli XCX",
            bgGradientStart = Color(0xFF11998e),
            bgGradientEnd = Color(0xFF38ef7d)
        )
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Editor's picks",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(playlists) { playlist ->
                PlaylistSquareCard(playlist)
            }
        }
    }
}

@Composable
fun PlaylistSquareCard(playlist: PlaylistCard) {
    Column(modifier = Modifier.width(155.dp)) {
        Box(
            modifier = Modifier
                .size(155.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(
                    brush = androidx.compose.ui.graphics.Brush.linearGradient(
                        colors = listOf(playlist.bgGradientStart, playlist.bgGradientEnd)
                    )
                )
                .padding(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.6f))
                    .align(Alignment.TopStart)
            )

            Text(
                text = playlist.coverTitle,
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = playlist.description,
            color = Color(0xFFA7A7A7),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            lineHeight = 16.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpotifyHomeScreenPreview() {
    SpotifyHomeScreen()
}

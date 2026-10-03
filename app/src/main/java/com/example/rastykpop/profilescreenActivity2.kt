package com.example.rastykpop

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class StoryHighlight(
    val id: Int,
    val title: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBackClick: () -> Unit = {},
    onMoreClick: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "username",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color.Black
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onMoreClick) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Options",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            ProfileHeaderSection()

            Spacer(modifier = Modifier.height(12.dp))
            ProfileBioSection()

            Spacer(modifier = Modifier.height(16.dp))
            ActionButtonsSection()

            Spacer(modifier = Modifier.height(20.dp))
            StoryHighlightsSection()
        }
    }
}

@Composable
fun ProfileHeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val instagramGradient = Brush.sweepGradient(
            colors = listOf(
                Color(0xFFF99B4E),
                Color(0xFFDF2074),
                Color(0xFF962FBF),
                Color(0xFF4F5BD5),
                Color(0xFFF99B4E)
            )
        )

        Box(
            modifier = Modifier
                .size(96.dp)
                .border(width = 3.dp, brush = instagramGradient, shape = CircleShape)
                .padding(5.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "🐶", fontSize = 40.sp)
            }
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatItem(count = "0,000", label = "Posts")
            StatItem(count = "0,000", label = "Followers")
            StatItem(count = "0,000", label = "Following")
        }
    }
}

@Composable
fun StatItem(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = count,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color.Black
        )
        Text(
            text = label,
            fontSize = 13.sp,
            color = Color.Black
        )
    }
}

@Composable
fun ProfileBioSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Username",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(2.dp))

        val bioText = buildAnnotatedString {
            append("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ")
            withStyle(SpanStyle(color = Color(0xFF1B80E4))) {
                append("#hashtag")
            }
        }
        Text(
            text = bioText,
            fontSize = 14.sp,
            color = Color.Black,
            lineHeight = 18.sp
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Link goes here",
            color = Color(0xFF1B80E4),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable { /* Click Handler */ }
        )

        Spacer(modifier = Modifier.height(4.dp))

        val mutualFollowersText = buildAnnotatedString {
            append("Followed by ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("username")
            }
            append(" and ")
            withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                append("username")
            }
        }
        Text(
            text = mutualFollowersText,
            fontSize = 13.sp,
            color = Color.DarkGray
        )
    }
}

@Composable
fun ActionButtonsSection() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFDBDBDB)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
        ) {
            Text(text = "Button", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0095F6),
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(text = "Follow", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFDBDBDB)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Text(text = "Message", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFDBDBDB)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Text(text = "Email", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier.size(36.dp),
                shape = RoundedCornerShape(8.dp),
                contentPadding = PaddingValues(0.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFDBDBDB)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Dropdown",
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun StoryHighlightsSection() {
    val stories = listOf(
        StoryHighlight(1, "Story 1"),
        StoryHighlight(2, "Story 2"),
        StoryHighlight(3, "Story 3"),
        StoryHighlight(4, "Story 4"),
        StoryHighlight(5, "Story 5")
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 4.dp)
    ) {
        items(stories) { story ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .border(1.dp, Color(0xFFDBDBDB), CircleShape)
                        .padding(3.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                            .background(Color(0xFFEFEFEF)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🖼️", fontSize = 24.sp)
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = story.title,
                    fontSize = 12.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}





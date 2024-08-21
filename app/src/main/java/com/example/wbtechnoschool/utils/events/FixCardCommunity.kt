package com.example.wbtechnoschool.utils.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entities.Community
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.button.SubscribeButton

@Composable
fun FixCardCommunity(
    modifier: Modifier = Modifier,
    community: Community,
    onClick: () -> Unit
) {
    Column(modifier = Modifier
        .clip(shape = RoundedCornerShape(16.dp))
        .clickable { onClick() }
        .width(104.dp)
    ) {
        Box(
            modifier = modifier
                .size(104.dp)
                .clip(shape = RoundedCornerShape(10.dp))
        ) {
            FixMyAvatar(
                modifier =
                Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .fillMaxSize(),
                contentDescription = null,
                model =
                community.icon
                    ?: "https://w7.pngwing.com/pngs/21/228/png-transparent-computer-icons-user-profile-others-miscellaneous-face-monochrome.png"
            )
        }
        Text(
            text = community.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.W600,
            fontSize = 14.sp
        )
        SubscribeButton(
            background = listOf(
                LightColorTheme.blushPink,
                LightColorTheme.petalPink,
                LightColorTheme.cottonCandy,
                LightColorTheme.lavenderMist,
                LightColorTheme.softLilac,
                LightColorTheme.paleLavender,
                LightColorTheme.lavenderWhisper,
                LightColorTheme.frostedViolet,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
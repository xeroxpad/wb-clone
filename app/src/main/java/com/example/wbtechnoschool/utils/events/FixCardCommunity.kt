package com.example.wbtechnoschool.utils.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.MagicNumbers.Companion.DEFAULT_AVATAR

@Composable
fun FixCardCommunity(modifier: Modifier = Modifier, event: FixEvent, onClick: () -> Unit) {
    Column(
        modifier = modifier
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            FixMyAvatar(
                contentDescription = null,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                model = event.icon ?: DEFAULT_AVATAR
            )
        }
        Text(
            text = event.title,
            fontWeight = FontWeight.Bold,
            fontSize = MagicNumbers.CARD_COMMUNITY_TEXT_TITLE.sp,
            color = LightColorTheme.neutralActive
        )
    }
}
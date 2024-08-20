package com.example.wbtechnoschool.utils.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entities.FixEvent
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.avatar.FixMyAvatar
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.MagicNumbers.Companion.DEFAULT_AVATAR
import com.example.wbtechnoschool.utils.tags.FilterChips

@Composable
fun FixCardCommunity(modifier: Modifier = Modifier, event: FixEvent, onClick: () -> Unit) {
    val dateMeeting = event.date
    val locationMeeting = event.city
    val allTextMeeting = ("$dateMeeting · $locationMeeting")
    Column(
        modifier = modifier
            .clickable { onClick() }
            .width(320.dp)
    ) {
        Box(
            modifier = Modifier
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
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = event.title,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            color = LightColorTheme.black,
            maxLines = 2,
            lineHeight = 30.sp
        )
        Row {
            Text(
                text = allTextMeeting,
                fontFamily = fontSFPro,
                fontWeight = FontWeight.Light,
                fontSize = MagicNumbers.CARD_ACTIVE_MEETINGS_ROW_TEXT_FONT_SIZE.sp,
                color = LightColorTheme.indigoTwilight,
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            FilterChips(labelText = event.tagDevelopmentLanguage)
            FilterChips(labelText = event.tagGradeDeveloper)
            FilterChips(labelText = event.tagCityMeeting)
        }
    }
}

@Composable
fun FixCardCommunityMini(modifier: Modifier = Modifier, event: FixEvent, onClick: () -> Unit) {
    val dateMeeting = event.date
    val locationMeeting = event.city
    val allTextMeeting = ("$dateMeeting · $locationMeeting")
    Column(
        modifier = modifier
            .clickable { onClick() }
            .width(212.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Spacer(modifier = Modifier.height(5.dp))
            FixMyAvatar(
                contentDescription = null,
                modifier =
                Modifier
                    .fillMaxWidth()
                    .height(147.dp),
                model = event.icon ?: DEFAULT_AVATAR
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = event.title,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = LightColorTheme.black,
            maxLines = 2,
            lineHeight = 20.sp
        )
        Row {
            Text(
                text = allTextMeeting,
                fontFamily = fontSFPro,
                fontWeight = FontWeight.Light,
                fontSize = MagicNumbers.CARD_ACTIVE_MEETINGS_ROW_TEXT_FONT_SIZE.sp,
                color = LightColorTheme.indigoTwilight,
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Row() {
            FilterChips(labelText = event.tagDevelopmentLanguage)
            FilterChips(labelText = event.tagGradeDeveloper)
        }
    }
}
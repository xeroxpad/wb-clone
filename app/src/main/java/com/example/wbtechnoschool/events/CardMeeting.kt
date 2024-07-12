package com.example.wbtechnoschool.events

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.chips.FilterChips
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun CardActiveMeetings(onClick: () -> Unit, meetings: Meetings) {
    Card(
        onClick = { onClick() }, colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
        ) {
            MyPreviewAvatar(
                modifier = Modifier
                    .size(48.dp),
                painter = painterResource(id = meetings.icon),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                val dateMeeting = stringResource(id = meetings.date)
                val locationMeeting = stringResource(id = meetings.city)
                val allTextMeeting = ("$dateMeeting - $locationMeeting")
                Text(
                    text = meetings.title,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = LightColorTheme.neutralActive
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = allTextMeeting,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    FilterChips(labelText = meetings.tagDevelopmentLanguage)
                    FilterChips(labelText = meetings.tagGradeDeveloper)
                    FilterChips(labelText = meetings.tagCityMeeting)
                }
            }
        }
        HorizontalDivider(color = SpaceGreyLight)
    }
}

@Composable
fun CardCompletedMeetings(meetings: Meetings) {
    Card(
        onClick = { /*TODO*/ }, colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
        ) {
            MyPreviewAvatar(
                modifier = Modifier
                    .size(48.dp),
                painter = painterResource(id = meetings.icon),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp),
            ) {
                val dateMeeting = stringResource(id = meetings.date)
                val locationMeeting = stringResource(id = meetings.city)
                val allTextMeeting = ("$dateMeeting - $locationMeeting")
                Row() {
                    Text(
                        text = meetings.title,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        color = LightColorTheme.neutralActive
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(id = R.string.state_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = allTextMeeting,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    FilterChips(labelText = meetings.tagDevelopmentLanguage)
                    FilterChips(labelText = meetings.tagGradeDeveloper)
                    FilterChips(labelText = meetings.tagCityMeeting)
                }
            }
        }
    }
    HorizontalDivider(color = SpaceGreyLight)
}

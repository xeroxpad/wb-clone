package com.example.wbtechnoschool.utils.events

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
import com.example.domain.entities.Meetings
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.utils.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.utils.chips.FilterChips
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight
import com.example.wbtechnoschool.ui.theme.fontSFPro
import com.example.wbtechnoschool.utils.constants.MagicNumbers

@Composable
fun CardActiveMeetings(modifier: Modifier = Modifier, meetings: Meetings, onClick: () -> Unit) {
    val dateMeeting = stringResource(id = meetings.date)
    val locationMeeting = stringResource(id = meetings.city)
    val allTextMeeting = ("$dateMeeting - $locationMeeting")
    Card(
        onClick = { onClick() }, colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = MagicNumbers.CARD_ACTIVE_MEETINGS_ROW_PADDING_TOP.dp)
        ) {
            MyPreviewAvatar(
                modifier = Modifier
                    .size(MagicNumbers.CARD_ACTIVE_MEETINGS_MY_PREV_AVATAR_SIZE.dp),
                painter = painterResource(id = meetings.icon),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.CARD_ACTIVE_MEETINGS_COLUMN_PADDING_HORIZONTAL.dp)
            ) {

                Text(
                    text = meetings.title,
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.Bold,
                    fontSize = MagicNumbers.CARD_ACTIVE_MEETINGS_TEXT_FONT_SIZE.sp,
                    color = LightColorTheme.neutralActive
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = allTextMeeting,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = MagicNumbers.CARD_ACTIVE_MEETINGS_ROW_TEXT_FONT_SIZE.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(modifier = Modifier.padding(bottom = MagicNumbers.CARD_ACTIVE_MEETINGS_ROW_PADDING_BOTTOM.dp)) {
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
fun CardCompletedMeetings(modifier: Modifier = Modifier, meetings: Meetings, onClick: () -> Unit) {
    val dateMeeting = stringResource(id = meetings.date)
    val locationMeeting = stringResource(id = meetings.city)
    val allTextMeeting = ("$dateMeeting - $locationMeeting")
    Card(
        onClick = { onClick() }, colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = MagicNumbers.CARD_COMPLETED_MEETINGS_ROW_PADDING_TOP.dp)
        ) {
            MyPreviewAvatar(
                modifier = Modifier
                    .size(MagicNumbers.CARD_COMPLETED_MEETINGS_MY_PREV_AVATAR_SIZE.dp),
                painter = painterResource(id = meetings.icon),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = MagicNumbers.CARD_COMPLETED_MEETINGS_COLUMN_PADDING_HORIZONTAL.dp),
            ) {
                Row{
                    Text(
                        text = meetings.title,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Bold,
                        fontSize = MagicNumbers.CARD_COMPLETED_MEETINGS_TEXT_FONT_SIZE.sp,
                        color = LightColorTheme.neutralActive
                    )
                    Spacer(modifier = Modifier.weight(MagicNumbers.CARD_COMPLETED_SPACER_WEIGHT))
                    Text(
                        text = stringResource(id = R.string.state_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = MagicNumbers.CARD_COMPLETED_MEETINGS_TEXT_END.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = allTextMeeting,
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = MagicNumbers.CARD_COMPLETED_MEETINGS_ROW_TEXT_FONT_SIZE.sp,
                        color = LightColorTheme.neutralWeak
                    )
                }
                Row(modifier = Modifier.padding(bottom = MagicNumbers.CARD_COMPLETED_MEETINGS_ROW_PADDING_BOTTOM.dp)) {
                    FilterChips(labelText = meetings.tagDevelopmentLanguage)
                    FilterChips(labelText = meetings.tagGradeDeveloper)
                    FilterChips(labelText = meetings.tagCityMeeting)
                }
            }
        }
    }
    HorizontalDivider(color = SpaceGreyLight)
}

package com.example.wbtechnoschool.events

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.GraphicsContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.chips.FilterChips
import com.example.wbtechnoschool.navigation.Graph
import com.example.wbtechnoschool.ui.theme.Neutral
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight
import com.example.wbtechnoschool.ui.theme.fontSFPro

@Composable
fun CardActiveMeetings(onClick: () -> Unit) {
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
                    .padding(start = 5.dp)
//                    .clickable {}
                    .size(48.dp),
                painter = painterResource(id = R.drawable.avatar_preview),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.name_meeting),
                    fontFamily = fontSFPro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.date_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Neutral
                    )
                    Text(
                        text = "-",
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp,
                        color = Neutral
                    )
                    Text(
                        text = stringResource(id = R.string.location_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Neutral
                    )
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    FilterChips(labelText = "Python")
                    FilterChips(labelText = "Junior")
                    FilterChips(labelText = "Moscow")
                }
            }
        }
        HorizontalDivider(color = SpaceGreyLight)
    }
}

@Composable
fun CardCompletedMeetings() {
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
                    .padding(start = 5.dp)
//                    .clickable {}
                    .size(48.dp),
                painter = painterResource(id = R.drawable.avatar_preview),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp)
            ) {
                Row() {
                    Text(
                        text = stringResource(id = R.string.name_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(id = R.string.state_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        color = Neutral
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.date_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Neutral
                    )
                    Text(
                        text = "-",
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 18.sp,
                        color = Neutral
                    )
                    Text(
                        text = stringResource(id = R.string.location_meeting),
                        fontFamily = fontSFPro,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Neutral
                    )
                }
                Row(modifier = Modifier.padding(bottom = 10.dp)) {
                    FilterChips(labelText = "Python")
                    FilterChips(labelText = "Junior")
                    FilterChips(labelText = "Moscow")
                }
            }
        }
    }
    HorizontalDivider(color = SpaceGreyLight)
}

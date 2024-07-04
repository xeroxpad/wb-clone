package com.example.wbtechnoschool.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.LightGrey
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight

@Composable
fun CardCommunity() {
    Card(
        onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 7.dp, start = 5.dp, bottom = 7.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row {
            MyPreviewAvatar(
                painter = painterResource(id = R.drawable.avatar_meeting),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 10.dp, bottom = 10.dp)
                    .clickable { }
                    .size(56.dp)
            )
            Column {
                Text(
                    text = stringResource(id = R.string.name_card_meeting),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = stringResource(id = R.string.current_users),
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp,
                    color = LightColorTheme.neutralDisabled
                )
            }
        }
        HorizontalDivider(color = SpaceGreyLight)
    }
}
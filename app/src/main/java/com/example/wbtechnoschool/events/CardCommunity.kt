package com.example.wbtechnoschool.events

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight
import com.example.wbtechnoschool.utils.MagicNumbers

@Composable
fun CardCommunity(
    modifier: Modifier = Modifier,
    community: Community,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row() {
            MyPreviewAvatar(
                painter = painterResource(id = community.icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        end = MagicNumbers.CARD_COMMUNITY_MY_PREV_AVATAR_PADDING_END.dp,
                        bottom = MagicNumbers.CARD_COMMUNITY_MY_PREV_AVATAR_PADDING_BOTTOM.dp
                    )
                    .size(MagicNumbers.CARD_COMMUNITY_MY_PREV_AVATAR_SIZE.dp)
            )
            Column {
                Text(
                    text = community.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = MagicNumbers.CARD_COMMUNITY_TEXT_TITLE.sp,
                    color = LightColorTheme.neutralActive
                )
                Text(
                    text = community.countPersons,
                    fontWeight = FontWeight.Light,
                    fontSize = MagicNumbers.CARD_COMMUNITY_TEXT_COUNT_PERSONS.sp,
                    color = LightColorTheme.neutralDisabled
                )
            }
        }
        HorizontalDivider(color = SpaceGreyLight)
    }
}
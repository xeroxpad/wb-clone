package com.example.wbtechnoschool.utils.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.entities.Community
import com.example.wbtechnoschool.utils.avatar.MyPreviewAvatar
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.ui.theme.SpaceGreyLight
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER

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
        Row {
            MyPreviewAvatar(
                contentDescription = null,
                modifier = Modifier
                    .size(MagicNumbers.CARD_ACTIVE_MEETINGS_MY_PREV_AVATAR_SIZE.dp),
                painter = community.icon ?: "https://banner2.cleanpng.com/20180901/prt/kisspng-luket-dner-consumer-production-logo-quality-a-verb-with-the-letter-k-my-pinterest-site-sym-5b8ae977b23648.94143731153583039173.jpg"
            )
            Spacer(modifier = Modifier.padding(horizontal = SPACER.SPACER_5.value.dp))
            Column {
                Text(
                    text = community.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = MagicNumbers.CARD_COMMUNITY_TEXT_TITLE.sp,
                    color = LightColorTheme.neutralActive
                )
                Text(
                    text = community.countPersons ?: "тут пока нет участников",
                    fontWeight = FontWeight.Light,
                    fontSize = MagicNumbers.CARD_COMMUNITY_TEXT_COUNT_PERSONS.sp,
                    color = LightColorTheme.neutralDisabled
                )
            }
        }
        Spacer(modifier = Modifier.padding(vertical = SPACER.SPACER_5.value.dp))
        HorizontalDivider(color = SpaceGreyLight)
    }
}
package com.example.wbtechnoschool.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wbtechnoschool.R
import com.example.wbtechnoschool.ui.theme.LightColorTheme
import com.example.wbtechnoschool.utils.constants.MagicNumbers
import com.example.wbtechnoschool.utils.constants.SPACER

@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    title: String? = null,
    iconBack: (() -> Unit)? = null,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
        modifier
            .fillMaxWidth()
            .padding(horizontal = MagicNumbers.MAIN_TOP_BAR_ROW_PADDING_HORIZONTAL.dp),
    ) {
        iconBack?.let {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .size(44.dp)
                    .clickable(onClick = iconBack),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_back),
                    contentDescription = null,
                    tint = LightColorTheme.fixVioletBlaze,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        title?.let {
            Text(
                text = title,
                fontSize = MagicNumbers.MAIN_TOP_BAR_TEXT_FONT_SIZE.sp,
                fontWeight = FontWeight.W500,
                color = LightColorTheme.neutralActive,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifierText
                    .padding(horizontal = 5.dp)
                    .widthIn(max = 280.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(16.dp))
                .size(44.dp)
                .clickable(onClick = {}),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_share),
                contentDescription = null,
                tint = LightColorTheme.fixVioletBlaze,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}
